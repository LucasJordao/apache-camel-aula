package com.apachecamel.aula.exercicio.infraestructure.dao;

import com.apachecamel.aula.exercicio.infraestructure.entity.BookEntity;
import com.apachecamel.aula.exercicio.infraestructure.mapper.row.BookRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

@UseClasspathSqlLocator
public interface BookDao {
    @SqlUpdate
    void insertBook(@BindBean BookEntity book);

    @SqlQuery
    @UseRowMapper(BookRowMapper.class)
    List<BookEntity> findByCategoryName(@Bind("categoryName") String categoryName);
}
