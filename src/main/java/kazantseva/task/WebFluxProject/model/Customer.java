package kazantseva.task.WebFluxProject.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private String name;

    private LocalDate dateOfBirth;

    private int age;
}
