package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_title")
    private String categoryTitle;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "photo_id")
    private String photoId;

    @Column(name = "logo_photo_id")
    private String logoPhotoId;

}
