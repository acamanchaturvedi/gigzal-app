package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Review extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "city")
    private String city;

    @CollectionTable(name = "review_photos", joinColumns = @JoinColumn(name = "review_id"))
    @Column(name = "photo_id")
    private List<String> photos;
}
