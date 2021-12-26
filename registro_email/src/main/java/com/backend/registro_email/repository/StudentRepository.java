package com.backend.registro_email.repository;

import com.backend.registro_email.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface StudentRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser>findByEmail(String email);
    @Transactional
    @Modifying
    @Query("UPDATE AppUser u SET u.enabled= true WHERE u.email=?1")
    int enableAppUser(String email);
}
