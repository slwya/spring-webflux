package com.example.springwebflux.global.handler;

import org.springframework.http.HttpStatus;

/**
 * <pre>
 * GraphQL BadRequest Excpetion
 * 클라이언트가 전달한 파라미터 등 요청 데이터에 문제가 있는 경우
 * </pre>
 */
public class GraphQlBadRequestException extends GraphQlCustomException {
    public GraphQlBadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "BAD_REQUEST");
    }
}
