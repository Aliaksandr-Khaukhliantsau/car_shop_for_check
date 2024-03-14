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
@Schema(description = "Information about the purchase")
public class PurchaseDto {

    @Schema(description = "ID")
    private UUID id;

    @Schema(description = "Number")
    private Integer purchaseNumber;

    @Schema(description = "Customer")
    private CustomerDto customer;

    @Schema(description = "Car")
    private CarDto car;
}