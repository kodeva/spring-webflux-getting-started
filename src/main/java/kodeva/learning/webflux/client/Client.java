package kodeva.learning.webflux.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class Client {
    private WebClient client = WebClient.create("http://localhost:8082");

    private Mono<ClientResponse> result = client.get()
            .uri("/hello")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    public void testRequest() {
        System.out.println("... Launching test request");
        Mono<String> mono = result.flatMap(res -> res.bodyToMono(String.class));
        mono.subscribe(s -> System.out.format("...... Response received: '%s'", s));
        System.out.println("... Test request launched");
    }
}