package entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The Completion class is an entity representing a car completion.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Completion {

    /**
     * Unique identifier for the car completion.
     */
    private UUID id;

    /**
     * Name of the car completion.
     */
    private String completionName;

    /**
     * A list of Setting instances representing the settings of the car completion.
     */
    private List<Setting> settings;

    /**
     * Adds a setting to the list of car settings. If the list is null, it initializes a new ArrayList and adds the Setting to it.
     *
     * @param setting the Setting to be added to the list of car settings.
     */
    public void addSetting(Setting setting) {
        if (this.settings != null) {
            this.settings.add(setting);
        } else {
            this.settings = new ArrayList<>();
            this.settings.add(setting);
        }
    }
}
