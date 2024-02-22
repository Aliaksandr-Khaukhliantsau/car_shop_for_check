package car.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
