package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {
    private UUID carId;
    private String vin;
    private CarModelDto carModel;
}
