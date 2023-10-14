package dto;

import lombok.*;

import java.util.UUID;

/**
 * The CarOptionDto class is a data transfer object representing a car option.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarOptionDto {

    /**
     * Unique identifier for the car option.
     */
    private UUID optionId;

    /**
     * Name of the car option.
     */
    private String optionName;
}
