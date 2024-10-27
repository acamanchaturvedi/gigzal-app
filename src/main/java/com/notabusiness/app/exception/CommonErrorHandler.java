package com.notabusiness.app.exception;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CommonErrorHandler {

    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrorResponse handleAccessDeniedException(HttpServletRequest httpServletRequest, InsufficientAuthenticationException exception) {
        return new ApiErrorResponse(null, null, "Invalid token", exception.getMessage(), getUri(httpServletRequest), LocalDateTime.now());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrorResponse handleAccessDeniedException(HttpServletRequest httpServletRequest, BadCredentialsException exception) {
        return new ApiErrorResponse(null, null, "Invalid credentials", exception.getMessage(), getUri(httpServletRequest), LocalDateTime.now());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrorResponse handleAccessDeniedException(HttpServletRequest httpServletRequest, AuthenticationException exception) {
        return new ApiErrorResponse(null, null, "Authentication fail", exception.getMessage(), getUri(httpServletRequest), LocalDateTime.now());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleUnknownException(HttpServletRequest httpServletRequest, MissingServletRequestParameterException exception) {
        return new ApiErrorResponse(null, null, "Missing required field or values", exception.getMessage(), getUri(httpServletRequest), LocalDateTime.now());
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleApplicationException(HttpServletRequest httpServletRequest, ApplicationException exception) {
        return new ApiErrorResponse(null, null, exception.getMessage(), null, getUri(httpServletRequest), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleUnknownException(HttpServletRequest httpServletRequest, Exception exception) {
        return new ApiErrorResponse(null, null, "Internal server error", exception.getMessage(), getUri(httpServletRequest), LocalDateTime.now());
    }

    private String getUri(HttpServletRequest request) {
        String uri;
        uri = request.getRequestURI();
        if (uri.equals("/error")) {
            uri = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI).toString();
        }
        return uri;
    }

}
