package com.notabusiness.app.exception;

import lombok.Data;

@Data
public class ApplicationException extends RuntimeException {

    private final String message;
}
