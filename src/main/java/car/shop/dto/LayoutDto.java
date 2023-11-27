package car.shop.dto;

import car.shop.entity.Completion;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LayoutDto {

    private UUID id;

    private String layoutName;

    private UUID completionId;

    //    private List<Completion> completions = new ArrayList<>();
    private List<Completion> completions;
}
