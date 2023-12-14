package car.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "completions")
public class Completion {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "completion_name", nullable = false)
    private String completionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "layout_id")
    private Layout layout;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "completions_settings",
            joinColumns = @JoinColumn(name = "completion_id"),
            inverseJoinColumns = @JoinColumn(name = "setting_id")
    )
    private List<Setting> settings;
}
