package com.notabusiness.app.entity;

import com.notabusiness.app.util.StatusType;
import lombok.Data;

@Data
public class Status {

    private int id;
    private StatusType message;
    private String description;

}
