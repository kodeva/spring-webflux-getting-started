package kodeva.learning.webflux.server;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class Handler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Spring Webflux Example!"));
    }

    public Mono<ServerResponse> hello2(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Spring Webflux Example 2!"));
    }

    public Mono<ServerResponse> hello3(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Spring Webflux Example 3!"));
    }

    public Mono<ServerResponse> helloEcho(ServerRequest request) {
        String name = request.queryParam("name").orElse("NO NAME");
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject(String.format("Hello %s, Spring Webflux Example Echo!", name)));
    }
}