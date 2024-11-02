package com.notabusiness.app.exception;

import lombok.Data;

import java.util.UUID;

@Data
public class ApplicationException extends RuntimeException {

    private final String message;

    private final UUID transactionId;
}
