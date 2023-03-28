package com.example.springwebflux.domain;


import com.example.springwebflux.domain.product.controller.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


/**
 * webflux 레퍼런스(한글)
 * <a href="https://godekdls.github.io/Reactive%20Spring/springwebflux2/">...</a>
 *
 * 최신버전(영문)
 * <a href="https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-config">...</a>
 *
 * 참고 자료
 * <a href="https://hyunsoori.tistory.com/15">...</a>
 */

@Component
public class Router {
    private final ProductHandler productHandler;

    public Router(ProductHandler productHandler) {
        this.productHandler = productHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> productRouter() {
        return route()
            .path("/product", b1 -> b1

                    .GET("/{productCode}", productHandler::productByCode)
                    .GET("", productHandler::products)
                    .POST("",productHandler::save)
                    .DELETE("", productHandler::delete)

            ).build();
    }
}

/**
 * webflux에서 DispatcherHandler 같은 역할
 */
/*@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

}*/
