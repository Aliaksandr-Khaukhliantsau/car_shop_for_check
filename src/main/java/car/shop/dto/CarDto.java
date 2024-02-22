package car.shop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information about the car")
public class CarDto {

    @Schema(description = "ID")
    private UUID id;

    @Schema(description = "VIN")
    private String vin;

    @Schema(description = "Layout")
    private LayoutDto layout;
}
