package dto;

import lombok.*;

import java.util.UUID;

/**
 * The CustomerDto class is a data transfer object representing a customer.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {

    /**
     * Unique identifier for the customer.
     */
    private UUID id;

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