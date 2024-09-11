package com.notabusiness.app.entity;

import lombok.Data;

@Data
public class Location {

    private int locationId;
    private String name;
    private String lats;
    private String langs;
    private int userId;

}
