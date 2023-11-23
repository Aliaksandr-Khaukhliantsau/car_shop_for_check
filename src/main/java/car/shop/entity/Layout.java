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
@Table(name = "layouts")
public class Layout {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "layout_name", nullable = false)
    private String layoutName;

    @OneToMany(mappedBy = "layout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Completion> completions;
}
