package com.apachecamel.aula.exercicio.core.processor;

import com.apachecamel.aula.exercicio.core.domain.Book;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class BookValidationProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        Book req = exchange.getIn().getBody(Book.class);

        if (req.getTitle() == null || req.getTitle().isBlank())
            throw new BadRequestException("Campo 'title' é obrigatório");

        if (req.getAuthor() == null || req.getAuthor().isBlank())
            throw new BadRequestException("Campo 'author' é obrigatório");

        if (req.getCategoryId() == null)
            throw new BadRequestException("Campo 'categoryId' é obrigatório");
    }
}
