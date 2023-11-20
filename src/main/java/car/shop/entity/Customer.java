package car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * The Customer class is an entity representing a customer.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    /**
     * Unique identifier for the customer.
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    /**
     * First name of the customer.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Middle name of the customer.
     */
    @Column(name = "middle_name")
    private String middleName;

    /**
     * Last name of the customer.
     */
    @Column(name = "last_name")
    private String lastName;
}
