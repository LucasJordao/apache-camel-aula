package com.apachecamel.aula.exercicio.core.router;

import com.apachecamel.aula.exercicio.core.processor.EmailValidationProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailRouter extends RouteBuilder {

    private final EmailValidationProcessor validator;

    @Override
    public void configure() throws Exception {
        onException(BadRequestException.class)
                .handled(false)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .setBody(simple("${exception.message}"));

        onException(Exception.class)
                .handled(false)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500))
                .setBody(constant("Erro interno ao enviar e-mail."));

        from("direct:email-send")
                .routeId("send-email-route")
                .log("Recebendo requisição para envio de e-mail")
                .process(validator)
                .bean("mailTrapService", "sendMail");
    }
}
