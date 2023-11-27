package car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "settings")
public class Setting {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "setting_name", unique = true, nullable = false)
    private String settingName;

//    @ManyToMany(mappedBy = "settings")
//    private List<Completion> completions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "completions_settings",
            joinColumns = @JoinColumn(name = "setting_id"),
            inverseJoinColumns = @JoinColumn(name = "completion_id")
    )
    private List<Completion> completions;
}