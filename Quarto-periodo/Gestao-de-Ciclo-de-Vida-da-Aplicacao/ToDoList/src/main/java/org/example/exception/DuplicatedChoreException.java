package org.example.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DuplicatedChoreException extends RuntimeException{
    public DuplicatedChoreException(String message) {
        super(message);
    }

}
