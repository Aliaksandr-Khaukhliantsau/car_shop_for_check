package dto;

import lombok.*;

import java.util.UUID;

/**
 * The CarModelDto class is a data transfer object representing a car model.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
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
