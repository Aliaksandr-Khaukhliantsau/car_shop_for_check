package entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarModel {
    private UUID modelId;
    private String modelName;
    private Completion completion;
}
