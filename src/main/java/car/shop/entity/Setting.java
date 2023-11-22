package car.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "settings")
public class Setting {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "setting_name", unique = true, nullable = false)
    private String settingName;

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "settings")
    @ManyToMany(mappedBy = "settings")
    private List<Completion> completions;
}