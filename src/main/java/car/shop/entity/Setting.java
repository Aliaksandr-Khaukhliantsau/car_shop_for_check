package car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * The Setting class is an entity representing a car setting.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Entity
@Table(name = "settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Setting {

    /**
     * Unique identifier for the car setting.
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    /**
     * Name of the car setting.
     */
    @Column(name = "setting_name")
    private String settingName;
}
