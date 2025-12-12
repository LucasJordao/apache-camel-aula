package com.apachecamel.aula.exercicio.core.port.out;

import com.apachecamel.aula.exercicio.infraestructure.entity.BookEntity;

import java.util.List;

public interface BookRepositoryPort {
    BookEntity createBook(BookEntity book);
    List<BookEntity> getBookByCategoryName(String categoryName);
}
