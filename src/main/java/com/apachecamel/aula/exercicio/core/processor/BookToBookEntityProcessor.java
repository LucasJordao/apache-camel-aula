package com.apachecamel.aula.exercicio.core.processor;

import com.apachecamel.aula.exercicio.core.domain.Book;
import com.apachecamel.aula.exercicio.infraestructure.entity.BookEntity;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookToBookEntityProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        Book req = exchange.getIn().getBody(Book.class);

        exchange.getIn().setBody(
                BookEntity.builder()
                        .title(req.getTitle())
                        .author(req.getAuthor())
                        .categoryId(req.getCategoryId())
                        .id(UUID.randomUUID())
                        .build()
        );
    }
}
