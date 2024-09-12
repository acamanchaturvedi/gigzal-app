package com.notabusiness.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workerId;

    private int userId;
    private LocalDateTime timestamp;
    private String bio;
    private String title;
    private String experience;
    private double totalRating;
    private int totalReviewCount;
    private String photoId;

}
