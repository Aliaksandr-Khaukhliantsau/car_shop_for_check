package car.shop.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "layout")
public class CompletionDto {

    private UUID id;

    private String completionName;

    private LayoutDto layout;

    private List<SettingDto> settings;
}