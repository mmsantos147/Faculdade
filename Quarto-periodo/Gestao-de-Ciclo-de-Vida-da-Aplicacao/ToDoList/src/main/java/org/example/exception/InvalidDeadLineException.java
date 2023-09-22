package org.example.exception;

public class InvalidDeadLineException extends RuntimeException {

    public InvalidDeadLineException (String message) {
        super(message);
    }
}
