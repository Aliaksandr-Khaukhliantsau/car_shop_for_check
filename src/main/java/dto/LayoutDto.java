package dto;

import lombok.*;

import java.util.UUID;

/**
 * The LayoutDto class is a data transfer object representing a car layout.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LayoutDto {

    /**
     * Unique identifier for the car layout.
     */
    private UUID id;

    /**
     * Name of the car layout.
     */
    private String layoutName;

    /**
     * An instance of CompletionDto representing the completion of the car layout.
     */
    private CompletionDto completion;
}
