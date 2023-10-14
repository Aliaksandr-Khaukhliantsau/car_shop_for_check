package entity;

import lombok.*;

import java.util.UUID;

/**
 * The CarModel class is an entity representing a car model.
 * It uses Lombok annotations for convenient boilerplate code reduction.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarModel {

    /**
     * Unique identifier for the car model.
     */
    private UUID modelId;

    /**
     * Name of the car model.
     */
    private String modelName;

    /**
     * An instance of Completion representing the completion of the car model.
     */
    private Completion completion;
}
