package car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "purchase")
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "vin", nullable = false)
    private String vin;

    @Column(name = "layout_id", nullable = false)
    private UUID layoutId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "layout_id", insertable = false, updatable = false)
    private Layout layout;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id") // purchase_id or id????
    private Purchase purchase;
}
