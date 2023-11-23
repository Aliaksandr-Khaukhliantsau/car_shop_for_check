package car.shop.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * The LayoutDto class is a data transfer object representing a car layout.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LayoutDto {

    private UUID id;
    private String layoutName;
    private List<CompletionDto> completions;
}
