package entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Completion {
    private UUID completionId;
    private String completionName;
    private List<CarOption> carOptions;

    public void addCarOption(CarOption carOption) {
        if (this.carOptions != null) {
            this.carOptions.add(carOption);
        } else {
            this.carOptions = new ArrayList<>();
            this.carOptions.add(carOption);
        }
    }
}
