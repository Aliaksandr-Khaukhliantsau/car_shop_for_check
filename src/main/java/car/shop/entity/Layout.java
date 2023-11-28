package car.shop.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(name = "completion_id", nullable = false)
    private UUID completionId;

    @OneToMany(mappedBy = "layout", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @BatchSize(size = 10)
    private List<Completion> completions = new ArrayList<>();
}
