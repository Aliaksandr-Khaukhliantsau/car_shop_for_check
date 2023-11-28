package car.shop.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "completions")
public class SettingDto {

    private UUID id;

    private String settingName;

    private List<CompletionDto> completions;
}
