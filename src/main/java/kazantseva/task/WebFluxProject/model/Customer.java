package kazantseva.task.WebFluxProject.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String name;

    private LocalDate dateOfBirth;

    private int age;
}
