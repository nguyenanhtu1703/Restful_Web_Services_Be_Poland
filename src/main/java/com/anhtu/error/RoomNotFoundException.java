package com.anhtu.error;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String name) {
        super("Room name not found: " + name);
    }
}
