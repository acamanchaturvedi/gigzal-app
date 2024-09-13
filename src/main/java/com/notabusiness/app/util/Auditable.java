package com.notabusiness.app.util;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
public class Auditable {

    @CreatedBy
    @Column(name = "created_by")
    public String createdBy;

    @CreatedDate
    @Column(name = "created_date")
    public LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    public String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_date")
    public LocalDateTime modifiedDate;

}
