package dto;

import lombok.*;

import java.util.UUID;

/**
 * The PurchaseDto class is a data transfer object representing a purchase.
 * It uses Lombok annotations for convenient boilerplate code reduction.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseDto {

    /**
     * Unique identifier for the purchase.
     */
    private UUID purchaseId;

    /**
     * Purchase number.
     */
    private int purchaseNumber;

    /**
     * An instance of CustomerDto representing the customer who made the purchase.
     */
    private CustomerDto customer;

    /**
     * An instance of CarDto representing the car that was purchased.
     */
    private CarDto car;
}