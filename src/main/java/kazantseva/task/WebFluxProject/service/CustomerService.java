package kazantseva.task.WebFluxProject.service;

import kazantseva.task.WebFluxProject.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

@Service
@AllArgsConstructor
public class CustomerService {

    private final RabbitTemplate rabbitTemplate;

    public ServerResponse receiveCustomer(Customer customer) {
        rabbitTemplate.convertAndSend("", "q.receive-customer", customer);
        return ServerResponse.ok().build().block();
    }
}
