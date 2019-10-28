package com.anhtu.error;

public class RoomExistedException extends RuntimeException {
    public RoomExistedException(String name) {
        super("Room name exixted: " + name);
    }
}
