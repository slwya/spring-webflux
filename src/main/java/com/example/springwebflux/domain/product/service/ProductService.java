package com.example.springwebflux.domain.product.service;


import com.example.springwebflux.domain.product.dto.ProductInput;
import com.example.springwebflux.domain.product.entity.Product;
import com.example.springwebflux.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 상품 조회
     * @param productCode 상품코드
     * @return 상품 데이터
     */
    public Mono<Product> productByCode(Long productCode) {
        return productRepository.findById(productCode);
    }

    /**
     * 상품리스트 조회
     * @return 상품 리스트 데이터
     */
    public Flux<Product> products() {
        return productRepository.findAll();
    }

    /**
     * 상품 입력
     * @param productInput dto
     * @return 입력 결과
     */
    public Mono<Void> insertProduct(ProductInput productInput) {
        return productRepository.save(new Product(productInput));
    }

    /**
     * 상품 삭제
     * @param productCode 상품코드
     * @return 삭제 결과
     */
    public Mono<Void> deleteProduct(Long productCode) {
        return productRepository.deleteById(productCode);
    }
}
