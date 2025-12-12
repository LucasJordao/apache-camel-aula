package com.apachecamel.aula.exercicio.core.service;

import com.apachecamel.aula.exercicio.core.domain.Book;
import com.apachecamel.aula.exercicio.core.port.in.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.apachecamel.aula.exercicio.core.router.BookRouter.ROUTE_GET_BY_CATEGORY;
import static com.apachecamel.aula.exercicio.core.router.BookRouter.ROUTE_URI;

@Service
@RequiredArgsConstructor
public class BookService implements BookServicePort {

    private final ProducerTemplate producerTemplate;

    @Override
    public void createBook(Book model) {
        producerTemplate.requestBody(ROUTE_URI, model);
    }

    @Override
    public List<Book> getByCategory(String category) {
        return producerTemplate.requestBody(ROUTE_GET_BY_CATEGORY, category, List.class);
    }
}
