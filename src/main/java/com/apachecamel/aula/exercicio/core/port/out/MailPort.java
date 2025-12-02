package com.apachecamel.aula.exercicio.core.port.out;

import com.apachecamel.aula.exercicio.core.domain.EmailMessage;

public interface MailPort {
    void sendMail(EmailMessage message);
}
