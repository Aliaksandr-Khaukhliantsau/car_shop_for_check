package entity;

import lombok.*;

import java.util.UUID;

/**
 * The Setting class is an entity representing a car setting.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Setting {

    /**
     * Unique identifier for the car setting.
     */
    private UUID id;

    /**
     * Name of the car setting.
     */
    private String settingName;
}
