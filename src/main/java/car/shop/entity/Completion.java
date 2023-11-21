package car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "completions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Completion {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "completion_name")
    private String completionName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "completions_settings",
            joinColumns = @JoinColumn(name = "completion_id"),
            inverseJoinColumns = @JoinColumn(name = "setting_id"))
    private List<Setting> settings;
}
