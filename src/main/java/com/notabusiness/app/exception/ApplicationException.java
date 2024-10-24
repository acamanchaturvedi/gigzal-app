package com.notabusiness.app.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApplicationException extends RuntimeException {

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;
}
