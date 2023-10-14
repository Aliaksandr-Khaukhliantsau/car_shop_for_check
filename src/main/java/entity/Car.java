package entity;

import lombok.*;

import java.util.UUID;

/**
 * The Car class is an entity representing a car.
 * It uses Lombok annotations for convenient boilerplate code reduction.
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
     * Vehicle Identification Number of the car.
     */
    private String vin;

    /**
     * An instance of CarModel representing the model of the car.
     */
    private CarModel carModel;
}
