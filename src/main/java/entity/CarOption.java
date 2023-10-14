package entity;

import lombok.*;

import java.util.UUID;

/**
 * The CarOption class is an entity representing a car option.
 * It uses Lombok annotations for convenient boilerplate code reduction.
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
