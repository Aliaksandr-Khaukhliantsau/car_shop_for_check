package dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * The CompletionDto class is a data transfer object representing a car completion.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
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
    private UUID id;

    /**
     * Name of the car completion.
     */
    private String completionName;

    /**
     * A list of SettingDto instances representing the settings of the car completion.
     */
    private List<SettingDto> settings;
}