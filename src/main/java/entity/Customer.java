package entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private UUID customerId;
    private String firstName;
    private String middleName;
    private String lastName;
}
