package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseDTO {
    private UUID purchaseId;
    private int purchaseNumber;
    private CustomerDTO customer;
    private CarDTO car;
}