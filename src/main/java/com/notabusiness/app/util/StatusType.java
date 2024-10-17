package com.notabusiness.app.util;

public enum StatusType {

    NEW("New"),
    PENDING_FOR_APPROVAL("Pending for Approval"),
    APPROVED("Approved"),
    CANCELLED("Cancelled"),
    ACTIVE("Active"),
    COMPLETED("Completed"),
    REVIEWED("Reviewed");

    private final String message;

    StatusType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}
