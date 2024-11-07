package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import com.notabusiness.app.enums.UserRole;

import java.io.Serializable;

@Data
@Entity
public class Users extends Auditable implements Serializable {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "photo_id")
    private String photoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole = UserRole.USER;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
