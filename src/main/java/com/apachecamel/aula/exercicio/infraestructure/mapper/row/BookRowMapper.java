package com.apachecamel.aula.exercicio.infraestructure.mapper.row;

import com.apachecamel.aula.exercicio.infraestructure.entity.BookEntity;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class BookRowMapper implements RowMapper<BookEntity> {

    @Override
    public BookEntity map(ResultSet rs, StatementContext ctx) throws SQLException {
       return BookEntity.builder()
                .author(rs.getString("author"))
                .title(rs.getString("title"))
                .categoryId(UUID.fromString(rs.getString("category_id")))
                .build();
    }
}
