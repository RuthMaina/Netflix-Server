package com.example.netflix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public void notFoundException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public void globalExceptionHandler(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(DontMatchException.class)
    public void dontMatchException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(AdminPrivilegeException.class)
    public void adminPrivilegeException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(UnknownException.class)
    public void unknownException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    @ExceptionHandler(RelationshipException.class)
    public void RelationshipException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value());
    }
}
