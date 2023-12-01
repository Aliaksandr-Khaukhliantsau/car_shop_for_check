package car.shop.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "purchase")
public class CarDto {

    private UUID id;

    private String vin;

    private UUID layoutId;

    private LayoutDto layout;

    private PurchaseDto purchase;
}
