package com.backend.registro_email.repository;

import com.backend.registro_email.model.token.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long> {
    Optional<ConfirmationToken>findByToken(String token);
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken ct set ct.confirmeaT =?2 WHERE ct.token=?1")
    int updateConfirmeAt(String token, LocalDateTime confirmeAt);
}
