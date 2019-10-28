package com.anhtu.error;

public class LoginAndPasswordNotMatchException extends RuntimeException {
    public LoginAndPasswordNotMatchException() {
        super("User not existed");
    }
}
