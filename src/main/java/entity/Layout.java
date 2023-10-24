package entity;

import lombok.*;

import java.util.UUID;

/**
 * The Layout class is an entity representing a car layout.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Layout {

    /**
     * Unique identifier for the car layout.
     */
    private UUID id;

    /**
     * Name of the car layout.
     */
    private String layoutName;

    /**
     * An instance of Completion representing the completion of the car layout.
     */
    private Completion completion;
}
