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

    private Integer purchaseNumber;

    private CustomerDto customer;

    private CarDto car;
}