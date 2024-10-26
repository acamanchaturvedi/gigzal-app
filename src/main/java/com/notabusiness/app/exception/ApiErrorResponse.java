package com.notabusiness.app.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiErrorResponse {

    private final String transactionId; // transactionId coming from FE or traceId
    private final String errorCode; // custom error code
    private final String customMessage; // custom message
    private final String message; // exception message
    private final String path; // url of endpoint
    private final LocalDateTime timestamp; // timestamp of the error creation

}
