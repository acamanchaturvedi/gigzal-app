package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Skill extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Faq> faqs;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "photo_ids")
    private String photoIds;

    @Column(name = "logo_photo_id")
    private String logoPhotoId;
}