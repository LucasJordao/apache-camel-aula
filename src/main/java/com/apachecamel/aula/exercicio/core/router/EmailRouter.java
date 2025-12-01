package com.apachecamel.aula.exercicio.core.router;

import com.apachecamel.aula.exercicio.core.domain.EmailMessage;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmailRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(RuntimeException.class)
                .handled(true)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .setBody(simple("${exception.message}"));

        onException(Exception.class)
                .handled(true)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500))
                .setBody(constant("Erro interno ao enviar e-mail."));

        from("direct:send-email")
                .routeId("send-email-route")
                .log("Recebendo requisição para envio de e-mail")
                .unmarshal().json(EmailMessage.class)
                .process();
    }
}
