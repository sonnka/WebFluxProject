# WebFluxProject
WebFluxProject - Spring WebFlux application with RabbitMQ  integration for efficient message queuing and parallel processing. 

The controller receives customer data and sends it to a RabbitMQ queue. 
The listner consumes messages and prints customer attributes (name, date of birth, age). 
WebClient calls the controller and sends multiple customers in parallel.

## Technology Stack
The WebFluxProject project incorporates a range of technologies to deliver its functionality:
- Java 17
- Spring WebFlux
- RabbitMQ
- Lombok
