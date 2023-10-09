package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private UUID customer_id;
    private String first_name;
    private String middle_name;
    private String last_name;
}