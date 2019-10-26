package com.example.netflix.exceptions;

public class UnknownException extends RuntimeException {
    public UnknownException(String message) {
        super(message);
    }
}
