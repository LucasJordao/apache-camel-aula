package com.apachecamel.aula.exercicio.core.mapper;

import com.apachecamel.aula.exercicio.core.domain.Book;
import com.apachecamel.aula.exercicio.infraestructure.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book toDomain(BookEntity entity) {
        return Book.builder()
                .author(entity.getAuthor())
                .title(entity.getTitle())
                .categoryId(entity.getCategoryId())
                .build();
    }

    public List<Book> toDomainList(List<BookEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}