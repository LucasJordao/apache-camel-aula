package com.apachecamel.aula.exercicio.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Book {
    private String title;
    private String author;
    private UUID categoryId;
}
