package kazantseva.task.WebFluxProject.controller;

import kazantseva.task.WebFluxProject.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {

    private RabbitTemplate rabbitTemplate;

    @PostMapping("/receive")
    public void receiveCustomer(@RequestBody Customer customer){
        rabbitTemplate.convertAndSend("q.receive-customer",customer);
    }
}
