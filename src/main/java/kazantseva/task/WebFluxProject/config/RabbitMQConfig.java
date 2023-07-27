package kazantseva.task.WebFluxProject.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue receiveCustomerQueue() {
        return new Queue("q.receive-customer");
    }

}
