package com.apachecamel.aula.exercicio.application.controller;

import com.apachecamel.aula.exercicio.application.request.EmailRequest;
import com.apachecamel.aula.exercicio.core.domain.EmailMessage;
import com.apachecamel.aula.exercicio.core.port.in.EmailServicePort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/email")
public class EmailController {

    private final EmailServicePort emailServicePort;
    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody EmailRequest payload) {
        emailServicePort.sendEmail(
                EmailMessage.builder()
                        .body(payload.getBody())
                        .to(payload.getTo())
                        .subject(payload.getSubject())
                        .build()
        );
        return ResponseEntity.noContent().build();
    }
}
