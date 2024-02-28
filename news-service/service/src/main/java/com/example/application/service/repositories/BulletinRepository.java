package com.example.application.service.repositories;

import com.example.application.service.model.domain.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BulletinRepository extends JpaRepository<Bulletin, Long>, JpaSpecificationExecutor<Bulletin> {
    @Query("select item from Bulletin item where item.id = :bulletinId and item.accountId = :accountId")
    Optional<Bulletin> findByIdAndAccountId(@Param("bulletinId") Long bulletinId, @Param("accountId") Long accountId);

}
