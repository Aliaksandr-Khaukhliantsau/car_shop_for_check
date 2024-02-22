package car.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
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

    private List<CompletionDto> completions = new ArrayList<>();
}