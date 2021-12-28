package com.backend.registro_email.utils.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class EmailService implements EmailSend{

    private final JavaMailSender javaMailSender;
    @Override
    @Async
    public void send(String to, String email) {
        try {

            javaMailSender.send(convertEmailSimple(to, email));
        } catch (MailException e) {
            throw new IllegalStateException("falha ao enviar email"+e);
        }
    }
    public  SimpleMailMessage convertEmailSimple(String to,String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("paulo.luiz980@gmail.com");
        message.setTo(to);
        message.setSubject("paulo.luiz980@gmail.com");
        message.setText(email);
        return message;

    }

}
