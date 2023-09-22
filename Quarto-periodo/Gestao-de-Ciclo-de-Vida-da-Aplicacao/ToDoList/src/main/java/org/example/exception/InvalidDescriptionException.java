package org.example.exception;

public class InvalidDescriptionException extends RuntimeException {

    public InvalidDescriptionException (String message) {
        super(message);
    }
}
