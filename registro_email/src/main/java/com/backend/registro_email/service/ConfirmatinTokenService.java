package com.backend.registro_email.service;

import com.backend.registro_email.model.token.ConfirmationToken;
import com.backend.registro_email.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmatinTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void save(ConfirmationToken confirmationToken){
        confirmationTokenRepository.save(confirmationToken);
    }

    public Optional<ConfirmationToken> getToken(String token){
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmatAt(String token){
        return confirmationTokenRepository.updateConfirmeAt(token,LocalDateTime.now());
    }

}
