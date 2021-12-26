package com.backend.registro_email.service;

import com.backend.registro_email.model.AppUser;
import com.backend.registro_email.model.AppUserRole;
import com.backend.registro_email.model.request.RegistroRequest;
import com.backend.registro_email.model.token.ConfirmationToken;
import com.backend.registro_email.utils.email.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistroService {
    private final CustumerAppUserService custumerAppUserService;
    private final ConfirmatinTokenService confirmatinTokenService;
   private final EmailValidator emailValidator;
    public String registro(RegistroRequest registroRequest){
        if(!emailValidator.test(registroRequest.getEmail())) throw new IllegalStateException("Email invalido ");

        String token =custumerAppUserService.signUpUser(
                new AppUser(
                        registroRequest.getFistName(),
                        registroRequest.getLastName(),
                        registroRequest.getEmail(),
                        registroRequest.getPassword(),
                        AppUserRole.USER
                )
        );

        return token;
    }
    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken = confirmatinTokenService
                .getToken(token)
                .orElseThrow(()-> new IllegalStateException("nao encontrou o token")
        );
        if(confirmationToken.getConfirmeaT()!=null){
            throw  new IllegalStateException("email ja foi confirmado");}
        if(confirmationToken.getExpiredAt().isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token ja foi expirado");
        }
        confirmatinTokenService.setConfirmatAt(token);
        custumerAppUserService.enabledAppUser(confirmationToken.getAppUser().getEmail());
        return "email confirmado";
    }
}
