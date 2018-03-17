package kodeva.learning.webflux.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> routeHello(Handler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);

    }

    @Bean
    public RouterFunction<ServerResponse> routeHelloOneStepFurther(Handler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello2").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello2)
                .andRoute(RequestPredicates.GET("/hello3").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello3)
                .andRoute(RequestPredicates.GET("/helloEcho").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::helloEcho);

    }
}