package kazantseva.task.WebFluxProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kazantseva.task.WebFluxProject.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.Sender;

@Service
@AllArgsConstructor
public class CustomerService {

    private final Sender sender;
    private final ObjectMapper objectMapper;

    public Mono<Void> receiveCustomer(Customer customer) {
        byte[] customerBytes = serializeCustomer(customer);
        return sender.send(Mono.just(new OutboundMessage("", "q.receive-customer", customerBytes)))
                .then();
    }

    private byte[] serializeCustomer(Customer customer) {
        try {
            return objectMapper.writeValueAsBytes(customer);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing customer: " + e.getMessage());
        }
    }
}
