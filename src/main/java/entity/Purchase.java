package entity;

import lombok.*;

import java.util.UUID;

/**
 * The Purchase class is an entity representing a purchase.
 * It uses Lombok annotations for convenient boilerplate code reduction.
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
    private UUID purchaseId;

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
