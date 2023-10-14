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
    private UUID completionId;

    /**
     * Name of the car completion.
     */
    private String completionName;

    /**
     * A list of CarOption instances representing the options of the car completion.
     */
    private List<CarOption> carOptions;

    /**
     * Adds a CarOption to the list of car options. If the list is null, it initializes a new ArrayList and adds the CarOption to it.
     *
     * @param carOption The CarOption to be added to the list of car options.
     */
    public void addCarOption(CarOption carOption) {
        if (this.carOptions != null) {
            this.carOptions.add(carOption);
        } else {
            this.carOptions = new ArrayList<>();
            this.carOptions.add(carOption);
        }
    }
}
