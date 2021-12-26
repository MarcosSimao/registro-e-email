package com.backend.registro_email.service;

import com.backend.registro_email.model.AppUser;
import com.backend.registro_email.model.CustomAppUserDetails;
import com.backend.registro_email.model.token.ConfirmationToken;
import com.backend.registro_email.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustumerAppUserService implements UserDetailsService {
    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmatinTokenService confirmatinTokenService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = Optional.ofNullable(studentRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("email nao encontrado")));
        return optionalAppUser.map(CustomAppUserDetails::new).get();
    }

    public String signUpUser(AppUser appUser){
        if(studentRepository.findByEmail(appUser.getEmail()).isPresent()){
           throw new IllegalStateException("email já cadastrado");
        }
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        studentRepository.save(appUser);
        String token= UUID.randomUUID().toString();
        ConfirmationToken confirmationToken= new ConfirmationToken(
              token,
              LocalDateTime.now(),
              LocalDateTime.now().plusMinutes(15),
                appUser
        );
        confirmatinTokenService.save(confirmationToken);
        return token;
    }
    public int enabledAppUser(String email){
        return studentRepository.enableAppUser(email);
    }

}
