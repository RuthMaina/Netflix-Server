package com.example.netflix.models;

import lombok.*;

import java.util.Date;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
