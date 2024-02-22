package com.example.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String statusCode;
    private String url;
    private String timestamp;
}
