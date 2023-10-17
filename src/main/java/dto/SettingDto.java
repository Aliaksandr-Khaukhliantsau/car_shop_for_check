package dto;

import lombok.*;

import java.util.UUID;

/**
 * The SettingDto class is a data transfer object representing a car setting.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SettingDto {

    /**
     * Unique identifier for the car setting.
     */
    private UUID id;

    /**
     * Name of the car setting.
     */
    private String settingName;
}
