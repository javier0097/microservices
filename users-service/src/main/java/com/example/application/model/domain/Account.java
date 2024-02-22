package com.example.application.model.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "account_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Schema(description = "Account model")
public class Account {
    @Id
    @Column(name = "accountid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avatarid", length = 100)
    private String avatarId;

    @Enumerated(EnumType.STRING)
    @Column(name = "accountstate", length = 50)
    private AccountState accountState;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate", nullable = false, updatable = false)
    private Date createdDate;

    @PrePersist
    void onPrePersist() {
        this.createdDate = new Date();
    }
}
