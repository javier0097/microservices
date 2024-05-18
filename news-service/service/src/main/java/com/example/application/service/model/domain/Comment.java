package com.example.application.service.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import static com.example.application.service.model.domain.Constants.BulletinTable;
import static com.example.application.service.model.domain.Constants.CommentTable;

@Setter
@Getter
@Entity
@Table(
        name = CommentTable.NAME
)
public class Comment implements Serializable {

    @Id
    @Column(name = CommentTable.Id.NAME, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = CommentTable.AccountId.NAME, nullable = false, updatable = false)
    private Long accountId;

    @Column(name = CommentTable.SenderUserId.NAME, nullable = false, updatable = false)
    private Long senderUserId;

    @Column(name = CommentTable.TextId.NAME, length = CommentTable.TextId.LENGTH, nullable = false)
    private String textId;

    @Column(name = CommentTable.ParentId.NAME, updatable = false)
    private Long parentId;

    @Column(name = CommentTable.RepliesCounter.NAME)
    private Integer repliesCounter;

    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    @Column(name = CommentTable.IsDeleted.NAME, nullable = false)
    private Boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = CommentTable.CreatedDate.NAME, nullable = false, updatable = false)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = CommentTable.BulletinId.NAME, referencedColumnName = BulletinTable.Id.NAME, nullable = false)
    private Bulletin bulletin;

    @PrePersist
    void onPrePersist() {
        this.repliesCounter = 0;
        this.createdDate = new Date();
        this.isDeleted = Boolean.FALSE;
    }
}
