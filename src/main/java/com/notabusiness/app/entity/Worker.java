package com.notabusiness.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private int workerId;

    @Column(name = "user_id")
    private int userId;

    private LocalDateTime timestamp;

    private String bio;

    private String title;

    private String experience;

    @Column(name = "total_rating")
    private double totalRating;

    @Column(name = "total_review_count")
    private int totalReviewCount;

    @Column(name = "photo_id")
    private String photoId;

}
