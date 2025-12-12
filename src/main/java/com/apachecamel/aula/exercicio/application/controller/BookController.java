package com.apachecamel.aula.exercicio.application.controller;

import com.apachecamel.aula.exercicio.application.request.BookRequest;
import com.apachecamel.aula.exercicio.core.domain.Book;
import com.apachecamel.aula.exercicio.core.port.in.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/livros")
public class BookController {

    private final BookServicePort bookServicePort;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookRequest payload) {
        bookServicePort.createBook(
                Book.builder()
                        .title(payload.getTitle())
                        .author(payload.getAuthor())
                        .categoryId(payload.getCategoryId())
                        .build()
        );
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getByCategory(
            @RequestParam String categoria
    ) {
        return ResponseEntity.ok(
                bookServicePort.getByCategory(categoria)
        );
    }
}
