package kazantseva.task.WebFluxProject.webclient;

import kazantseva.task.WebFluxProject.model.Customer;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class CustomerWebClient {

    private static final WebClient webClient = WebClient.create("http://localhost:8080");
    private static final Random random = new Random();
    private static final Customer[] customers;

    static {
        LocalDate start = LocalDate.of(1923, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2020, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, end);

        customers = IntStream.range(0, 100)
                .mapToObj(i -> {
                    LocalDate randomDate = start.plusDays(random.nextInt((int) days + 1));
                    int randomAge = 3 + random.nextInt(98);
                    return new Customer("Tom" + i, randomDate, randomAge);
                })
                .toArray(Customer[]::new);
    }

    private static void receive(Customer customer) {
        webClient.post()
                .uri("/receive")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(customer), Customer.class)
                .retrieve()
                .bodyToMono(ServerResponse.class)
                .block();
    }

    public static void parallel() {
        Arrays.stream(customers)
                .parallel()
                .forEach(CustomerWebClient::receive);
    }
}
