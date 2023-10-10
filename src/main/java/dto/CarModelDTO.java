package dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarModelDTO {
    private UUID modelId;
    private String modelName;
    private CompletionDTO completion;
}
