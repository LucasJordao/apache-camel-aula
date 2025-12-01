package com.apachecamel.aula.exercicio.core.port.in;

import com.apachecamel.aula.exercicio.core.domain.EmailMessage;

public interface EmailServicePort {
    void sendEmail(EmailMessage message);
}
