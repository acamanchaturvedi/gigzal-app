package com.notabusiness.app.entity;

import com.notabusiness.app.util.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Faq extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faq_id")
    private int faqId;

    private String question;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "skill_id")
    private Long skillId;

    private String answer;

}
