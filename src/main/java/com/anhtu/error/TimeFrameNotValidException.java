package com.anhtu.error;

public class TimeFrameNotValidException extends RuntimeException {
    public TimeFrameNotValidException() {
        super("Time frame not valid");
    }
}
