package car.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "layouts")
public class Layout {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "layout_name", nullable = false)
    private String layoutName;

    @OneToMany(mappedBy = "layout", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @BatchSize(size = 10)
    private List<Completion> completions;

    @OneToMany(mappedBy = "layout", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @BatchSize(size = 10)
    private List<Car> cars;
}
