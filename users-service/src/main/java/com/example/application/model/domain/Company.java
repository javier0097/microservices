package com.example.application.model.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "company_table")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "companyid", referencedColumnName = "userid")
})
public class Company extends User {

    @Column(name = "name1", length = 100, nullable = false)
    private String name;
}
