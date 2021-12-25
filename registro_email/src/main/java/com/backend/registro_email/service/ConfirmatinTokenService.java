package com.backend.registro_email.service;

import com.backend.registro_email.model.token.ConfirmationToken;
import com.backend.registro_email.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmatinTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void save(ConfirmationToken confirmationToken){
        confirmationTokenRepository.save(confirmationToken);
    }
}
