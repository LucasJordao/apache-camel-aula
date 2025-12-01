package com.apachecamel.aula.exercicio.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmailMessage {
    private String to;
    private String subject;
    private String body;
}
