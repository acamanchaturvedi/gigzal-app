package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Location extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;

    private String name;

    private String lats;

    private String langs;

    @Column(name = "user_id")
    private int userId;

}
