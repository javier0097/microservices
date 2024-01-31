package com.example.application.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "person_table")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "personid", referencedColumnName = "userid")
})
public class Person extends User {

    @Column(name = "firstname", length = 100, nullable = false)
    private String firstName;

    @Column(name = "lastname", length = 100, nullable = false)
    private String lastName;
}
