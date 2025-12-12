package com.apachecamel.aula.exercicio.core.port.in;

import com.apachecamel.aula.exercicio.core.domain.Book;

import java.util.List;

public interface BookServicePort {
    void createBook(Book model);

    List<Book> getByCategory(String category);
}
