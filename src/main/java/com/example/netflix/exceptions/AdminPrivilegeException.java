package com.example.netflix.exceptions;

public class AdminPrivilegeException extends RuntimeException {
    public AdminPrivilegeException(String message) {
        super(message);
    }
}
