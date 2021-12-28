package com.backend.registro_email;

import com.backend.registro_email.model.AppUser;
import com.backend.registro_email.model.AppUserRole;
import com.backend.registro_email.repository.StudentRepository;
import com.backend.registro_email.service.CustumerAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RegistroEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroEmailApplication.class, args);
	}



}

