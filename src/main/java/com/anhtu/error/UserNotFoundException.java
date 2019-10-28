package com.anhtu.error;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String login) {
        super("User login not found: " + login);
    }
}
