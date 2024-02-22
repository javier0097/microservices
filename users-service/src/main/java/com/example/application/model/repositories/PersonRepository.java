package com.example.application.model.repositories;


import com.example.application.model.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // "SELECT * where firstName =" + firstName;

//    List<Person> findByFirstNameAndLastNameOrderByCreatedDateDesc(String firstName, String lastName);

    @Query("select item from Person item where item.firstName=?1 and item.lastName = ?2 order by  item.createdDate desc")
    List<Person> findByFirstNameAndLastNameOrdered(String firstName, String lastName);

//    @Query("select item from Person item where item.firstName=:firstName and item.lastName = :lastName order by  item.createdDate desc")
//    List<Person> findByFirstNameAndLastNameOrdered(@Param("firstName") String firstName, @Param("lastName") String lastName);
    //Optional<Person> findByFirstNameAndLastNameOrdered(@Param("firstName") String firstName,@Param("lastName") String lastName);
}
