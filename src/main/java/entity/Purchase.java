package entity;

import lombok.*;

import java.util.UUID;

/**
 * The Purchase class is an entity representing a purchase.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Purchase {

    /**
     * Unique identifier for the purchase.
     */
    private UUID id;

    /**
     * Purchase number.
     */
    private int purchaseNumber;

    /**
     * An instance of Customer representing the customer who made the purchase.
     */
    private Customer customer;

    /**
     * An instance of Car representing the car that was purchased.
     */
    private Car car;
}
