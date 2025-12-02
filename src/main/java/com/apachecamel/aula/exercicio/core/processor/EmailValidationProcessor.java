package com.apachecamel.aula.exercicio.core.processor;

import com.apachecamel.aula.exercicio.core.domain.EmailMessage;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class EmailValidationProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        EmailMessage req = exchange.getIn().getBody(EmailMessage.class);

        if (req.getTo() == null || req.getTo().isBlank())
            throw new BadRequestException("Campo 'to' é obrigatório");

        if (req.getSubject() == null || req.getSubject().isBlank())
            throw new BadRequestException("Campo 'subject' é obrigatório");

        if (req.getBody() == null || req.getBody().isBlank())
            throw new BadRequestException("Campo 'body' é obrigatório");

        if (!req.getTo().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new BadRequestException("E-mail inválido");

        if (containsMalicious(req.getSubject()))
            throw new BadRequestException("Subject contém caracteres inválidos");

        if (containsMalicious(req.getBody()))
            throw new BadRequestException("Body contém caracteres inválidos");
    }

    private boolean containsMalicious(String text) {
        return text.contains("<script>") || text.contains(";");
    }
}
