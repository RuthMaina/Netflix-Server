package com.example.netflix.exceptions;

public class DontMatchException extends RuntimeException {
    public DontMatchException(String message) {
        super(message);
    }
}
