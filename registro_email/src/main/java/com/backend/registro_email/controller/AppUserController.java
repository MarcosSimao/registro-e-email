package com.backend.registro_email.controller;

import com.backend.registro_email.model.request.RegistroRequest;
import com.backend.registro_email.service.RegistroService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@RequiredArgsConstructor
public class AppUserController {
    private final RegistroService registroService;

    @PostMapping
    public String register(@RequestBody RegistroRequest registroRequest){
        return registroService.registro(registroRequest);
    }
}
