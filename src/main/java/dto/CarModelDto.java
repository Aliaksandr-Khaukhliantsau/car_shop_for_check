package dto;

import lombok.*;

import java.util.UUID;

/**
 * The CarModelDto class is a data transfer object representing a car model.
 * It uses Lombok annotations for convenient boilerplate code reduction.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarModelDto {

    /**
     * Unique identifier for the car model.
     */
    private UUID modelId;

    /**
     * Name of the car model.
     */
    private String modelName;

    /**
     * An instance of CompletionDto representing the completion of the car model.
     */
    private CompletionDto completion;
}
