package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDTO {
    private UUID carId;
    private String vin;
    private CarModelDTO carModel;
}
