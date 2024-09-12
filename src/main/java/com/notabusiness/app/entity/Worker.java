package com.notabusiness.app.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Worker {

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
