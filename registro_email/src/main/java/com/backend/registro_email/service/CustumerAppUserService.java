package com.backend.registro_email.service;

import com.backend.registro_email.model.AppUser;
import com.backend.registro_email.model.CustomAppUserDetails;
import com.backend.registro_email.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustumerAppUserService implements UserDetailsService {
    private final StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = Optional.ofNullable(studentRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("email nao encontrado")));
        return optionalAppUser.map(CustomAppUserDetails::new).get();
    }
}
