package kazantseva.task.WebFluxProject.service;

import kazantseva.task.WebFluxProject.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerReceivingListener {
    @RabbitListener(queues = {"q.receive-customer"})
    public void onCustomerReceiving(Customer event) {
        log.info(event.toString());
    }
}
