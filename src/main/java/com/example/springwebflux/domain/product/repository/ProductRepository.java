package com.example.springwebflux.domain.product.repository;

import com.example.springwebflux.domain.product.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <pre>
 * product repository
 * </pre>
 */

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    // 상품코드로 찾기
    Mono<Product> findById(Long productCode);

    // 상품전체
    Flux<Product> findAll();

    // 삭제
    Mono<Void> deleteById(Long productCode);

    // 추가
    Mono<Void> save(Product product);
}
