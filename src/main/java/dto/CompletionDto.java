package dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * The CompletionDto class is a data transfer object representing a car completion.
 * It uses Lombok annotations for convenient boilerplate code reduction.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompletionDto {

    /**
     * Unique identifier for the car completion.
     */
    private UUID completionId;

    /**
     * Name of the car completion.
     */
    private String completionName;

    /**
     * A list of CarOptionDto instances representing the options of the car completion.
     */
    private List<CarOptionDto> carOptions;
}