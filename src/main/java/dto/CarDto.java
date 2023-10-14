package dto;

import lombok.*;

import java.util.UUID;

/**
 * The CarDto class is a data transfer object representing a car.
 * It uses Lombok annotations for convenient boilerplate code reduction.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {

    /**
     * Unique identifier for the car.
     */
    private UUID carId;

    /**
     * Vehicle Identification Number of the car.
     */
    private String vin;

    /**
     * An instance of CarModelDto representing the model of the car.
     */
    private CarModelDto carModel;
}
