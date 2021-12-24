package com.backend.registro_email;

import com.backend.registro_email.model.AppUser;
import com.backend.registro_email.model.AppUserRole;
import com.backend.registro_email.repository.StudentRepository;
import com.backend.registro_email.service.CustumerAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class RegistroEmailApplication {
	private final StudentRepository studentRepository;
	private  final CustumerAppUserService custumerAppUserService;
	public static void main(String[] args) {
		SpringApplication.run(RegistroEmailApplication.class, args);
	}
//	@Bean
//	public void init(){
//		AppUser app = new AppUser();
//		app.setEmail("leti@teste");
//		app.setUsername("leti");
//		app.setAppUserRole(AppUserRole.ADMIN);
//		app.setEnabled(true);
//		app.setLocked(true);
//		app.setName("leti");
//		app.setPassword("123456");
//		studentRepository.save(app);
//	}



}

