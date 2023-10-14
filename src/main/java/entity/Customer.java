package entity;

import lombok.*;

import java.util.UUID;

/**
 * The Customer class is an entity representing a customer.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    /**
     * Unique identifier for the customer.
     */
    private UUID customerId;

    /**
     * First name of the customer.
     */
    private String firstName;

    /**
     * Middle name of the customer.
     */
    private String middleName;

    /**
     * Last name of the customer.
     */
    private String lastName;
}
