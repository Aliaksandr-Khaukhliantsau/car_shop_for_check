package car.shop.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseDto {

    private UUID id;

    private int purchaseNumber;

//    private UUID customerId;

//    private UUID carId;

    private CustomerDto customer;

    private CarDto car;
}