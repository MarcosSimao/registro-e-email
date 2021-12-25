package com.backend.registro_email.service;

import com.backend.registro_email.model.AppUser;
import com.backend.registro_email.model.AppUserRole;
import com.backend.registro_email.model.request.RegistroRequest;
import com.backend.registro_email.utils.email.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistroService {
    private final CustumerAppUserService custumerAppUserService;
   private final EmailValidator emailValidator;
    public String registro(RegistroRequest registroRequest){
        if(!emailValidator.test(registroRequest.getEmail())) throw new IllegalStateException("Email invalido ");

        return custumerAppUserService.signUpUser(
                new AppUser(
                        registroRequest.getFistName(),
                        registroRequest.getLastName(),
                        registroRequest.getEmail(),
                        registroRequest.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
