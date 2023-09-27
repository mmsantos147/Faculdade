package org.example.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmptyChoreException extends RuntimeException {
    public EmptyChoreException (String message) {
        super(message);
    }
}
