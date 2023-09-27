package org.example.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChoreDoesntExistException extends RuntimeException {
    public ChoreDoesntExistException(String message){
        super(message);
    }

}
