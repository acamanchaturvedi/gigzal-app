package com.notabusiness.app.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiErrorResponse {

    private final String errorCode;
    private final String message;
    private final String customMessage;
    private final String path;
    private final LocalDateTime timestamp;

}
