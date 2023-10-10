package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private UUID customerId;
    private String firstName;
    private String middleName;
    private String lastName;
}