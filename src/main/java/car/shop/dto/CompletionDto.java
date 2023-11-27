package car.shop.dto;

import car.shop.entity.Layout;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "layout")
//@ToString
public class CompletionDto {

    private UUID id;

    private String completionName;

//    @ToString.Exclude
    private Layout layout;

    private List<SettingDto> settings;
}