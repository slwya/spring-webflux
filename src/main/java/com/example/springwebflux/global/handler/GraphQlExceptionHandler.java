package com.example.springwebflux.global.handler;


import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * GraphQL Exception 핸들러
 * </pre>
 */
@Component
public class GraphQlExceptionHandler implements DataFetcherExceptionResolver {
    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable exception, DataFetchingEnvironment environment) {
        // BadRequest Exception
        if (exception instanceof GraphQlBadRequestException badRequestException) {
            return Mono.just(Collections.singletonList(badRequestException));
        }

        // InternalServerError Exception
        if (exception instanceof GraphQlInternalServerErrorException internalServerErrorException) {
            return Mono.just(Collections.singletonList(internalServerErrorException));
        }

        // ConstraintViolationException
        // 파라미터 인자 @Valid 검증 실패 Exception, GraphQlBadRequestException 매핑
        // 참고: https://medium.com/javarevisited/spring-for-graphql-request-validation-8972f03e56e4
        if (exception instanceof ConstraintViolationException constraintViolationException) {
            List<GraphQLError> exceptionList = constraintViolationException.getConstraintViolations().stream()
                    .map(constraintViolation -> new GraphQlBadRequestException(constraintViolation.getMessage()))
                    .map(badRequestException -> (GraphQLError) badRequestException)
                    .collect(Collectors.toList());
            return Mono.just(exceptionList);
        }

        return null;
    }
}
