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
@Table(name = "completions")
public class Completion {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "completion_name", unique = true, nullable = false)
    private String completionName;

//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    @JoinTable(
            name = "completions_settings",
            joinColumns = @JoinColumn(name = "completion_id"),
            inverseJoinColumns = @JoinColumn(name = "setting_id")
    )
    private List<Setting> settings;
}
