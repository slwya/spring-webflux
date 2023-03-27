package com.example.springwebflux.domain.product.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * <pre>
 * 상품 input
 * </pre>
 */
public record ProductInput(
        // 상품 코드
        @Positive(message = "1이상 입력")
        Long productCode,

        // 상품 명
        String productName,

        // 상품 가격
        @PositiveOrZero(message = "0이상 입력")
        int price) {
}
