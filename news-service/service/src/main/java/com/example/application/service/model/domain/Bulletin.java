package com.example.application.service.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import static com.example.application.service.model.domain.Constants.BulletinTable;

@Setter
@Getter
@Entity
@Table(name = BulletinTable.NAME)
public class Bulletin implements Serializable {
    @Id
    @Column(name = BulletinTable.Id.NAME, nullable = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = BulletinTable.AccountId.NAME, nullable = false, updatable = false)
    private Long accountId;

    @Column(name = BulletinTable.SenderUserId.NAME, nullable = false, updatable = false)
    private Long senderUserId;

    @Column(name = BulletinTable.Body.NAME, length = BulletinTable.Body.LENGTH)
    private String body;

    @Column(name = BulletinTable.CreatedDate.NAME, nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = BulletinTable.PostDate.NAME, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;

    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    @Column(name = BulletinTable.IsDeleted.NAME, nullable = false)
    private Boolean isDeleted;

    @Column(name = BulletinTable.CommentsCounter.NAME)
    private Integer commentsCounter;

    @Column(name = BulletinTable.LikesCounter.NAME)
    private Integer likerCounter;

    private Integer age;

    @Transient
    private Integer portUserService;

    @PrePersist
    void onPrePersist(){
        this.commentsCounter = 0;
        this.likerCounter = 0;
        this.createdDate = new Date();
        this.postDate = new Date();
        this.isDeleted = false;
    }
}
