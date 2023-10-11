package dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompletionDto {
    private UUID completionId;
    private String completionName;
    private List<CarOptionDto> carOptions;
}