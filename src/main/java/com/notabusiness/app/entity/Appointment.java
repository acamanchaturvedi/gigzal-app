package com.notabusiness.app.entity;

import com.notabusiness.app.util.AppointmentShift;
import com.notabusiness.app.util.AppointmentType;
import com.notabusiness.app.util.Auditable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Appointment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "photo_id")
    private String photoId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private Users users;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_type")
    private AppointmentType appointmentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_shift")
    private AppointmentShift appointmentShift;

}
