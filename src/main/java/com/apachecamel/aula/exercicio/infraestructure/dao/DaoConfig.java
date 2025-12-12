package com.apachecamel.aula.exercicio.infraestructure.dao;

import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public BookDao bookDao(Jdbi jdbi) {
        return jdbi.onDemand(BookDao.class);
    }
}