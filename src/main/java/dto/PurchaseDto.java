package dto;

import lombok.*;

import java.util.UUID;

/**
 * The PurchaseDto class is a data transfer object representing a purchase.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
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
    private UUID id;

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