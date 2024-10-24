package com.notabusiness.app.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class CommonErrorHandler {

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<Object> handleAccessDeniedException(AuthenticationException ex) {
        return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiErrorResponse handleApplicationException(final ApplicationException exception, final HttpServletRequest request) {
        var guid = UUID.randomUUID().toString();
//        log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
        return new ApiErrorResponse(guid, exception.getErrorCode(), exception.getMessage(), exception.getHttpStatus().value(), exception.getHttpStatus().name(), request.getRequestURI(), request.getMethod(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleUnknownException(final Exception exception, final HttpServletRequest request) {
        var guid = UUID.randomUUID().toString();
//        log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
        return new ApiErrorResponse(guid, ErrorCodes.INTERNAL_ERROR, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), request.getRequestURI(), request.getMethod(), LocalDateTime.now());
    }

}
