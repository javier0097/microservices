package com.example.application.service.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import static com.example.application.service.model.domain.Constants.BulletinTable;
import static com.example.application.service.model.domain.Constants.RateBulletinLikesTable;

@Setter
@Getter
@Entity
@Table(
        name = RateBulletinLikesTable.NAME
)
public class RateBulletinLikes implements Serializable {

    @Id
    @Column(name = RateBulletinLikesTable.Id.NAME, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = RateBulletinLikesTable.AccountId.NAME, nullable = false, updatable = false)
    private Long accountId;

    @Column(name = RateBulletinLikesTable.UserId.NAME, nullable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = RateBulletinLikesTable.BulletinId.NAME, referencedColumnName = BulletinTable.Id.NAME, nullable = false)
    private Bulletin bulletin;
}

