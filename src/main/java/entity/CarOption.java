package entity;

import lombok.*;

import java.util.UUID;

/**
 * The CarOption class is an entity representing a car option.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarOption {

    /**
     * Unique identifier for the car option.
     */
    private UUID optionId;

    /**
     * Name of the car option.
     */
    private String optionName;
}
