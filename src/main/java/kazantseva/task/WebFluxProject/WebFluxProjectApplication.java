package kazantseva.task.WebFluxProject;

import kazantseva.task.WebFluxProject.webclient.CustomerWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebFluxProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxProjectApplication.class, args);
        CustomerWebClient.parallel();
    }

}
