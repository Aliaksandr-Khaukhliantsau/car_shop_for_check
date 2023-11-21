package car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Setting {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "setting_name")
    private String settingName;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "completions_settings",
//            joinColumns = @JoinColumn(name = "setting_id"),
//            inverseJoinColumns = @JoinColumn(name = "completion_id"))
//    private List<Completion> completions;
}

