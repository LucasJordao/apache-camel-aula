package com.apachecamel.aula.exercicio.core.router;

import com.apachecamel.aula.exercicio.core.mapper.BookMapper;
import com.apachecamel.aula.exercicio.core.port.out.BookRepositoryPort;
import com.apachecamel.aula.exercicio.core.processor.BookToBookEntityProcessor;
import com.apachecamel.aula.exercicio.core.processor.BookValidationProcessor;
import com.apachecamel.aula.exercicio.core.processor.EmailValidationProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookRouter extends RouteBuilder {

    public static final String ROUTE_URI = "direct:create-book";
    public static final String ROUTE_GET_BY_CATEGORY = "direct:get_book_by_category";

    private final BookValidationProcessor validator;
    private final BookToBookEntityProcessor processor;
    private final BookMapper mapper;

    private final BookRepositoryPort bookRepositoryPort;

    @Override
    public void configure() {
        from(ROUTE_URI)
            .log("Recebendo requisição para criação de livro")
            .process(validator)
            .process(processor)
            .doTry()
                .bean(bookRepositoryPort, "createBook")
            .doCatch(Exception.class)
                .log(LoggingLevel.ERROR, "Exception caught: ${exception.stacktrace}")
                .setBody(constant("Error in create book"))
            .end();


        from(ROUTE_GET_BY_CATEGORY)
                .routeId("get-book-by-category-route")
                .log("Searching books with category: ${body}")
                .bean(bookRepositoryPort, "getBookByCategoryName")
                .bean(mapper, "toDomainList")
                .end();
    }
}
