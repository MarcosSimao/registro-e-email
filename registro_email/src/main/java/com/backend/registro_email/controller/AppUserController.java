package com.backend.registro_email.controller;

import com.backend.registro_email.model.request.RegistroRequest;
import com.backend.registro_email.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@RequiredArgsConstructor
public class AppUserController {
    private final RegistroService registroService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegistroRequest registroRequest){
        return ResponseEntity.ok(registroService.registro(registroRequest));
    }
   @GetMapping("confirm")
   public ResponseEntity<String>confirm(@RequestParam("token") String token){
        return ResponseEntity.ok(registroService.confirmToken(token));
  }
}
