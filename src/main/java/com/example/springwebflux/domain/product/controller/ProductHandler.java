package com.example.springwebflux.domain.product.controller;

import com.example.springwebflux.domain.product.dto.ProductInput;
import com.example.springwebflux.domain.product.entity.Product;
import com.example.springwebflux.domain.product.service.ProductService;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class ProductHandler {
    private final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 상품 조회
     *
     * @return 상품
     */
    public Mono<ServerResponse> productByCode(ServerRequest request) {
        Long productCode = Long.valueOf(request.pathVariable("productCode"));
        return productService.productByCode(productCode)
                .flatMap(product -> ok().bodyValue(product))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     *
     * @return 상품 리스트
     */
    public Mono<ServerResponse> products(ServerRequest request) {
        Flux<Product> products = productService.products();
        return ok().body(products, Product.class);
    }

    /**
     * 상품 입력
     *
     * @return 저장 결과
     */
    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<ProductInput> productInput = request.bodyToMono(ProductInput.class);


        return ok().build(productService.insertProduct(productInput));
    }

    /**
     * 상품 삭제
     *
     * @return 저장 결과
     */
    public Mono<ServerResponse> delete(ServerRequest request) {
        Long productCode = Long.valueOf(request.pathVariable("productCode"));
        return ok().build(productService.deleteProduct(productCode));
    }
}
