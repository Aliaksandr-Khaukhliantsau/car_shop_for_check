package car.shop.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {

    private UUID id;

    private String vin;

    private UUID layoutId;

    private LayoutDto layout;
}
