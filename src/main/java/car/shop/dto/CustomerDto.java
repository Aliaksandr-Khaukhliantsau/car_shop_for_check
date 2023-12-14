package car.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "purchases")
public class CustomerDto {

    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    private List<PurchaseDto> purchases;
}