package entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Purchase {
    private UUID purchaseId;
    private int purchaseNumber;
    private Customer customer;
    private Car car;
}
