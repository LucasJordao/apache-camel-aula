package com.apachecamel.aula.exercicio.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmailRequest {
    private String to;
    private String subject;
    private String body;
}
