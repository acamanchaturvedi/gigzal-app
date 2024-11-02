package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import com.notabusiness.app.util.enums.StatusType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Status extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusId;

    private StatusType message;

    private String description;

}
