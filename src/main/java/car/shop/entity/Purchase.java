//package car.shop.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Entity
//@Table(name = "purchases")
//public class Purchase {
//
//    @Id
//    @GeneratedValue
//    private UUID id;
//
//    @Column(name = "purchase_number", unique = true, nullable = false)
//    @GeneratedValue
//    private int purchaseNumber;
//
//    @Column(name = "customer_id", nullable = false)
//    private UUID customerId;
//
//    @Column(name = "car_id", nullable = false)
//    private UUID carId;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "car_id")
//    private Car car;
//}



//package car.shop.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Entity
//@Table(name = "purchases")
//public class Purchase {
//
//    @Id
//    @GeneratedValue
//    private UUID id;
//
//    @Column(name = "purchase_number", unique = true, nullable = false)
//    @GeneratedValue
//    private int purchaseNumber;
//
////    @Column(name = "customer_id", nullable = false)
////    private UUID customerId;
//
//    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "car_id", nullable = false)
//    private Car car;
//}

package car.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "purchase_number", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchaseNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
