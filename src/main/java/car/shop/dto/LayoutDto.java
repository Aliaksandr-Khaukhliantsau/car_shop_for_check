package car.shop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information about the layout")
public class LayoutDto {

    @Schema(description = "ID")
    private UUID id;

    @Schema(description = "Name")
    private String layoutName;

    @Schema(description = "Completions")
    private List<CompletionDto> completions;
}