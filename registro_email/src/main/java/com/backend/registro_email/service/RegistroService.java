package com.backend.registro_email.service;

import com.backend.registro_email.model.request.RegistroRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {

    public String registro(RegistroRequest registroRequest){
        return "works";
    }
}
