package com.example.application.service.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import static com.example.application.service.model.domain.Constants.AttachmentTable;
import static com.example.application.service.model.domain.Constants.BulletinTable;

@Setter
@Getter
@Entity
@Table(name=AttachmentTable.NAME)
public class Attachment implements Serializable {
    @Id
    @Column(name = AttachmentTable.Id.NAME, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = AttachmentTable.AccountId.NAME, nullable = false, updatable = false)
    private Long accountId;

    @Column(name = AttachmentTable.FileId.NAME, length = AttachmentTable.FileId.LENGTH, nullable = false, updatable = false)
    private String fileId;

    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    @Column(name = AttachmentTable.IsDeleted.NAME, nullable = false)
    private Boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = AttachmentTable.CreatedDate.NAME, nullable = false, updatable = false)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = AttachmentTable.BulletinId.NAME, referencedColumnName = BulletinTable.Id.NAME, nullable = false)
    private Bulletin bulletin;

    @PrePersist
    void onPrePersist() {
        this.createdDate = new Date();
        this.isDeleted = false;
    }
}

