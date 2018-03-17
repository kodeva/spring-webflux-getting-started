package kodeva.learning.webflux.server;

import kodeva.learning.webflux.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void hello2_returns_example2() {
        webTestClient
                .get().uri("/hello2")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, Spring Webflux Example 2!");
    }

    @Test
    public void hello3_returns_example3() {
        webTestClient
                .get().uri("/hello3")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, Spring Webflux Example 3!");
    }

    @Test
    public void helloEcho_returns_text_with_name_when_name_is_sent() {
        webTestClient
                .get().uri("/helloEcho?name=Stepan")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello Stepan, Spring Webflux Example Echo!");
    }

    @Test
    public void helloEcho_returns_text_with_NONAME_when_name_is_absent() {
        webTestClient
                .get().uri("/helloEcho")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello NO NAME, Spring Webflux Example Echo!");
    }

    @Test
    public void helloDummy_returns_notFound() {
        webTestClient
                .get().uri("/helloDummy")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isNotFound();
    }
}
