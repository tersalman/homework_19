package com.example.homework19.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IlligalLetterException extends RuntimeException{
    public IlligalLetterException(String message) {
        super(message);
    }
}
