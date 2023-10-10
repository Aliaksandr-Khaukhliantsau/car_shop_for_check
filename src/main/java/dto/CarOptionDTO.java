package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarOptionDTO {
    private UUID optionId;
    private String optionName;
}
