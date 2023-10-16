package entity;

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
    private UUID carId;

    /**
     * Vehicle identification number of the car.
     */
    private String vin;

    /**
     * An instance of CarModel representing the model of the car.
     */
    private CarModel carModel;
}
