package car.shop.old.entity;

import lombok.*;

import java.util.UUID;

/**
 * The Car class is an entity representing a car.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    /**
     * Unique identifier for the car.
     */
    private UUID id;

    /**
     * Vehicle identification number of the car.
     */
    private String vin;

    /**
     * An instance of Layout representing the layout of the car.
     */
    private Layout layout;
}
