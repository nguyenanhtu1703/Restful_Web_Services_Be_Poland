package com.anhtu.error;

public class TimeFrameConflictException extends RuntimeException {
    public TimeFrameConflictException() {
        super("Time frame is conflicted!");
    }
}
