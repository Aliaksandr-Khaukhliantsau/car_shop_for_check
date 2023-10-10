package dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompletionDTO {
    private UUID completionId;
    private String completionName;
    private List<CarOptionDTO> carOptions;
}