package com.notabusiness.app.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiErrorResponse {

    private final String guid; // unique global identifier of the error, this field is useful for searching errors in a large log: "DCF70619-01D8-42a9-97DC-6005F205361A"
    private final String errorCode; // an application specific error code derived from business logic rules: "application-specific-error-code"
    private final String message; // description of an error: "Error message"
    private final Integer statusCode; // HTTP status code: 400
    private final String statusName; // full name of the HTTP status code: "BAD_REQUEST"
    private final String path; // URI of the resource where the error occurred: "/some/path"
    private final String method; // used HTTP method: "POST"
    private final LocalDateTime timestamp; // timestamp of the error creation: "2022-12-06"
    //todo add strack trace and other fields
}
