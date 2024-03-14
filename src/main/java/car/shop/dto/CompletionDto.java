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
@Schema(description = "Information about the completion")
public class CompletionDto {

    @Schema(description = "ID")
    private UUID id;

    @Schema(description = "Name")
    private String completionName;

    @Schema(description = "Settings")
    private List<SettingDto> settings;
}