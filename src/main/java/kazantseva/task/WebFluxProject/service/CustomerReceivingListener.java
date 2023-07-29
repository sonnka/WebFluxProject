package kazantseva.task.WebFluxProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import kazantseva.task.WebFluxProject.model.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.Receiver;

import java.io.IOException;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerReceivingListener {

    private final Receiver receiver;
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void startListening() {
        receiver.consumeAutoAck("q.receive-customer")
                .flatMap(message -> {
                    Customer customer = deserializeCustomer(message.getBody());
                    log.info(customer.toString());
                    return Mono.just(message);
                })
                .subscribe();
    }

    private Customer deserializeCustomer(byte[] body) {
        try {
            return objectMapper.readValue(body, Customer.class);
        } catch (IOException e) {
            log.error("Error deserializing customer: {}", e.getMessage());
            return null;
        }
    }
}
