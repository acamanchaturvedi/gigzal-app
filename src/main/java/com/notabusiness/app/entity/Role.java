package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import com.notabusiness.app.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Role extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;
}
