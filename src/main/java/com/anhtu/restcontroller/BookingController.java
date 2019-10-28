package com.anhtu.restcontroller;

import com.anhtu.entity.Reservation;
import com.anhtu.entity.TimeFrame;
import com.anhtu.entity.User;
import com.anhtu.error.*;
import com.anhtu.repository.BookingRepository;
import com.anhtu.repository.RoomRepository;
import com.anhtu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BookingRepository bookingRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/booking/book")
    Reservation newRoom(@RequestBody Reservation reservation) {
        User user = userRepository.findByLogin(reservation.getLogin());

        if (reservation.getRoomName() == null || user == null)
            throw new UserNotFoundException(reservation.getLogin());

        if (reservation.getPassword() == null || !user.getPassword().equals(reservation.getPassword()))
            throw new LoginAndPasswordNotMatchException();

        if (reservation.getRoomName() == null || roomRepository.findByName(reservation.getRoomName()) == null)
            throw new RoomNotFoundException(reservation.getRoomName());

        if (reservation.getFrom() == null || reservation.getTo() == null)
            throw new TimeFrameNotValidException();

        Boolean isConflict = bookingRepository.findByRoomName(reservation.getRoomName()).stream().anyMatch(x -> !(x.getFrom().after(reservation.getTo()) || x.getTo().before(reservation.getFrom())));

        if (isConflict == true)
            throw new TimeFrameConflictException();

        return bookingRepository.save(reservation);
    }

    @GetMapping("/booking")
    List<Reservation> findAllReservation() {
        return bookingRepository.findAll();
    }

    @PostMapping("/booking/allrooms")
    List<Reservation> findAll(@RequestBody TimeFrame timeFrame) {
        List<Reservation> result = new ArrayList<>();

        if (timeFrame.getFromDate() == null && timeFrame.getToDate() != null) {
            bookingRepository.findAll().forEach(x -> {
               if (x.getTo().before(timeFrame.getToDate()) || x.getTo().equals(timeFrame.getToDate())) {
                   result.add(x);
               }
            });
        } else if (timeFrame.getFromDate() != null && timeFrame.getToDate() == null) {
            bookingRepository.findAll().forEach(x -> {
                if (x.getFrom().after(timeFrame.getFromDate()) || x.getFrom().equals(timeFrame.getFromDate())) {
                    result.add(x);
                }
            });
        } else if (timeFrame.getFromDate() != null && timeFrame.getToDate() != null) {
            bookingRepository.findAll().forEach(x -> {
                if ((x.getFrom().after(timeFrame.getFromDate()) || x.getFrom().equals(timeFrame.getFromDate())) && (x.getTo().before(timeFrame.getToDate()) || x.getTo().equals(timeFrame.getToDate()))) {
                    result.add(x);
                }
            });
        } else {
            result.addAll(bookingRepository.findAll());
        }

        return result;
    }

    @PostMapping("/booking/listbyroom/{roomName}")
    List<Reservation> findReservationForARoom(@RequestBody TimeFrame timeFrame, @PathVariable String roomName) {
        List<Reservation> result = new ArrayList<>();

        if (timeFrame.getFromDate() == null && timeFrame.getToDate() != null) {
            bookingRepository.findByRoomName(roomName).forEach(x -> {
                if (x.getTo().before(timeFrame.getToDate()) || x.getTo().equals(timeFrame.getToDate())) {
                    result.add(x);
                }
            });
        } else if (timeFrame.getFromDate() != null && timeFrame.getToDate() == null) {
            bookingRepository.findByRoomName(roomName).forEach(x -> {
                if (x.getFrom().after(timeFrame.getFromDate()) || x.getFrom().equals(timeFrame.getFromDate())) {
                    result.add(x);
                }
            });
        } else if (timeFrame.getFromDate() != null && timeFrame.getToDate() != null) {
            bookingRepository.findByRoomName(roomName).forEach(x -> {
                if ((x.getFrom().after(timeFrame.getFromDate()) || x.getFrom().equals(timeFrame.getFromDate())) && (x.getTo().before(timeFrame.getToDate()) || x.getTo().equals(timeFrame.getToDate()))) {
                    result.add(x);
                }
            });
        } else {
            result.addAll(bookingRepository.findByRoomName(roomName));
        }

        return result;
    }

    @PostMapping("/booking/listbyuser/{login}")
    List<Reservation> findReservationForAUser(@RequestBody TimeFrame timeFrame, @PathVariable String login) {
        List<Reservation> result = new ArrayList<>();

        if (timeFrame.getFromDate() == null && timeFrame.getToDate() != null) {
            bookingRepository.findByLogin(login).forEach(x -> {
                if (x.getTo().before(timeFrame.getToDate()) || x.getTo().equals(timeFrame.getToDate())) {
                    result.add(x);
                }
            });
        } else if (timeFrame.getFromDate() != null && timeFrame.getToDate() == null) {
            bookingRepository.findByLogin(login).forEach(x -> {
                if (x.getFrom().after(timeFrame.getFromDate()) || x.getFrom().equals(timeFrame.getFromDate())) {
                    result.add(x);
                }
            });
        } else if (timeFrame.getFromDate() != null && timeFrame.getToDate() != null) {
            bookingRepository.findByLogin(login).forEach(x -> {
                if ((x.getFrom().after(timeFrame.getFromDate()) || x.getFrom().equals(timeFrame.getFromDate())) && (x.getTo().before(timeFrame.getToDate()) || x.getTo().equals(timeFrame.getToDate()))) {
                    result.add(x);
                }
            });
        } else {
            result.addAll(bookingRepository.findByLogin(login));
        }

        return result;
    }
}
