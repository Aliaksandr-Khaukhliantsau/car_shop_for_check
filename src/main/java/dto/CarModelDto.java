package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarModelDto {
    private UUID modelId;
    private String modelName;
    private CompletionDto completion;
}
