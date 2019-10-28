package com.anhtu.error;

public class UserExistedException extends RuntimeException {
    public UserExistedException(String login) {
        super("User login exixted: " + login);
    }
}
