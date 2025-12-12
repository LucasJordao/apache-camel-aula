package com.apachecamel.aula.exercicio.infraestructure.entity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookEntity {
    private UUID id;
    private String title;
    private String author;
    private UUID categoryId;
}
