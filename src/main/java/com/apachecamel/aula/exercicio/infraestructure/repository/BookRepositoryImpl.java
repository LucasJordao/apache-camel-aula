package com.apachecamel.aula.exercicio.infraestructure.repository;

import com.apachecamel.aula.exercicio.core.port.out.BookRepositoryPort;
import com.apachecamel.aula.exercicio.infraestructure.dao.BookDao;
import com.apachecamel.aula.exercicio.infraestructure.entity.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepositoryPort {
    private final BookDao dao;

    @Override
    public BookEntity createBook(BookEntity book) {
        dao.insertBook(book);

        return book;
    }

    @Override
    public List<BookEntity> getBookByCategoryName(String categoryName) {
        return dao.findByCategoryName(categoryName);
    }
}
