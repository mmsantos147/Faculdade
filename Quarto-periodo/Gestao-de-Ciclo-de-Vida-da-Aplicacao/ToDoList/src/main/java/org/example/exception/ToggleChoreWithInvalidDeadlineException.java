package org.example.exception;

public class ToggleChoreWithInvalidDeadlineException extends RuntimeException {
    public ToggleChoreWithInvalidDeadlineException (String message) {
        super(message);
    }
}
