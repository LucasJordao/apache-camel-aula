package com.apachecamel.aula.exercicio.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class BookRequest {
    @JsonProperty("titulo")
    private String title;
    @JsonProperty("autor")
    private String author;
    @JsonProperty("categoriaId")
    private UUID categoryId;
}
