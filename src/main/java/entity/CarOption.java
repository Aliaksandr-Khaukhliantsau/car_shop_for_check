package entity;

import java.util.UUID;

public class CarOption {
    private UUID optionId;
    private String optionName;

    public CarOption() {
    }

    public CarOption(UUID optionId, String optionName) {
        this.optionId = optionId;
        this.optionName = optionName;
    }

    public UUID getOptionId() {
        return optionId;
    }

    public void setOptionId(UUID optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public String toString() {
        return "CarOption{" +
                "optionId=" + optionId +
                ", optionName='" + optionName + '\'' +
                '}';
    }
}
