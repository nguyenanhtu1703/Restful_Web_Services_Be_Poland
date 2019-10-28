package com.anhtu.repository;

import com.anhtu.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAll();

    List<Reservation> findByRoomName(String roomName);

    List<Reservation> findByLogin(String login);
}

