package com.apachecamel.aula.exercicio.infraestructure;

import com.apachecamel.aula.exercicio.core.domain.EmailMessage;
import com.apachecamel.aula.exercicio.core.port.out.MailPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service("mailTrapService")
public class MailTrapService implements MailPort {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(EmailMessage message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(message.getTo());
        msg.setSubject(message.getSubject());
        msg.setText(message.getBody());

        mailSender.send(msg);

        log.info("Email enviado com sucesso");
    }
}
