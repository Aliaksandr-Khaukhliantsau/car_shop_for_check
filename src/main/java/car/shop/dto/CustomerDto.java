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
@Schema(description = "Information about the customer")
public class CustomerDto {

    @Schema(description = "ID")
    private UUID id;

    @Schema(description = "First name")
    private String firstName;

    @Schema(description = "Middle name")
    private String middleName;

    @Schema(description = "Last name")
    private String lastName;
}