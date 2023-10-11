package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseDto {
    private UUID purchaseId;
    private int purchaseNumber;
    private CustomerDto customer;
    private CarDto car;
}