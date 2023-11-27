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
//@ToString(exclude = "completions")
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

//    @OneToMany(mappedBy = "layout", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @BatchSize(size = 10)
//    private List<Completion> completions;

    @OneToMany(mappedBy = "layout", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "layout", cascade = CascadeType.REMOVE)
    @BatchSize(size = 10)
    private List<Completion> completions = new ArrayList<>();

//    @OneToMany(mappedBy = "layout", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @OneToMany(mappedBy = "layout", cascade = CascadeType.ALL, orphanRemoval = true)
//    @BatchSize(size = 10)
//    private List<Completion> completions = new ArrayList<>();

//    public void setCompletions(List<Completion> completions) {
//        this.completions = new ArrayList<Completion> (completions); // копируем список
//    }
}
