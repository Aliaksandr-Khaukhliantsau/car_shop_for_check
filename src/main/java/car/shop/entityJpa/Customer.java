package car.shop.entityJpa;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Customer {

    @Id
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;
}
