package com.apachecamel.aula.exercicio.core.service;

import com.apachecamel.aula.exercicio.core.domain.EmailMessage;
import com.apachecamel.aula.exercicio.core.port.in.EmailServicePort;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailServicePort {

    private final ProducerTemplate producerTemplate;

    @Override
    public void sendEmail(EmailMessage message) {
        Object response = producerTemplate.requestBody("direct:email-send", message);

    }
}
