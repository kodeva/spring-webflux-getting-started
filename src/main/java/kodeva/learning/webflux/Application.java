package kodeva.learning.webflux;


import kodeva.learning.webflux.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Client client = new Client();
        System.out.println(client.getResult());
    }
}