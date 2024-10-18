package com.notabusiness.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "temp_users")
public class TempUser {

    @Id
    private int id;

    private String username;

    private String password;

}
