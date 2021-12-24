package com.backend.registro_email.repository;

import com.backend.registro_email.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface StudentRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser>findByEmail(String email);
}
