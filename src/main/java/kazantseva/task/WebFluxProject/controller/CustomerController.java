package kazantseva.task.WebFluxProject.controller;

import kazantseva.task.WebFluxProject.model.Customer;
import kazantseva.task.WebFluxProject.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/receive")
    public Mono<Void> receiveCustomer(@RequestBody Customer customer) {
        return customerService.receiveCustomer(customer);
    }
}
