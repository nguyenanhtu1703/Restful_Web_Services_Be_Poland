package com.anhtu.repository;

import com.anhtu.entity.Room;
import com.anhtu.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {
    @Override
    List<Room> findAll();
    Room findByName(String name);
}

