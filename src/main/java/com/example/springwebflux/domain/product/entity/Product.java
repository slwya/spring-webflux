package com.example.springwebflux.domain.product.entity;


import com.example.springwebflux.domain.product.dto.ProductInput;
import org.springframework.data.annotation.Id;

/**
 * <pre>
 * product entity
 * </pre>
 */
public class Product {
    // 상품 코드
    @Id
    private Long productCode;

    // 상품 명
    private String productName;

    // 상품 가격
    private int price;

    public Product(ProductInput productInput) {
        this.productCode = productInput.productCode();
        this.productName = productInput.productName();
        this.price = productInput.price();
    }

    public Product() {

    }
}
