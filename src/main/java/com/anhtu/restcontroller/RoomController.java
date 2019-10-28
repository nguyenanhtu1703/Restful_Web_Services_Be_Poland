package com.anhtu.restcontroller;


import com.anhtu.entity.Room;
import com.anhtu.error.RoomExistedException;
import com.anhtu.error.RoomNotFoundException;
import com.anhtu.error.UserExistedException;
import com.anhtu.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/rooms/${secret.key}")
    Room newRoom(@Valid @RequestBody Room newRoom) {
        if (roomRepository.findByName(newRoom.getName()) != null) {
            throw new RoomExistedException(newRoom.getName());
        }

        return roomRepository.save(newRoom);
    }

    @PatchMapping("/rooms/${secret.key}/{name}")
    Room patch(@RequestBody Room room, @PathVariable String name) {
        roomRepository.findById(name).map(x -> {
            if (room.getLocation() != null)
                x.setLocation(room.getLocation());
            if (room.getPhoneNumber() != null)
                x.setPhoneNumber(room.getPhoneNumber());
            if (room.getProjector() != null)
                x.setProjector(room.getProjector());
            if (room.getSeats() != null)
                x.setSeats(room.getSeats());

            return roomRepository.save(x);
        }).orElseGet(() -> {
            throw new RoomNotFoundException(name);
        });

        return room;
    }

    @DeleteMapping("/rooms/${secret.key}/{name}")
    void deleteRoom(@PathVariable String name) {
        if (roomRepository.findByName(name) != null)
            roomRepository.deleteById(name);
        else
            throw new RoomNotFoundException(name);
    }

    @GetMapping("/rooms")
    List<Room> findAll() {
        return roomRepository.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserExistedException.class)
    public Map<String, String> handleValidationExceptions(UserExistedException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        System.out.println("User Existed!");
        return errors;
    }
}
