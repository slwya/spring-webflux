package com.example.springwebflux.global.handler;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * GraphQL Custom Exception Abstract Class
 * GraphQL 관련 사용자 예외는 해당 Class를 상속받아 구현한다.
 * </pre>
 */
public abstract class GraphQlCustomException extends RuntimeException implements GraphQLError {
    private HttpStatus status;
    private String exceptionMessage;

    public GraphQlCustomException(String message) {
        super(message);
    }

    public GraphQlCustomException(String message, HttpStatus status, String exceptionMessage) {
        super(message);
        this.status = status;
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttributes = new LinkedHashMap<>();
        customAttributes.put("status", status.value());
        customAttributes.put("exceptionMessage", exceptionMessage);
        return customAttributes;
    }
}
