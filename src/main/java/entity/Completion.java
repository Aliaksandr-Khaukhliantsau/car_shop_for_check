package entity;

import java.util.List;
import java.util.UUID;

public class Completion {
    private UUID completionId;
    private String completionName;
    private List<CarOption> carOptions;

    public Completion() {
    }

    public Completion(UUID completionId, String completionName, List<CarOption> carOptions) {
        this.completionId = completionId;
        this.completionName = completionName;
        this.carOptions = carOptions;
    }

    public UUID getCompletionId() {
        return completionId;
    }

    public void setCompletionId(UUID completionId) {
        this.completionId = completionId;
    }

    public String getCompletionName() {
        return completionName;
    }

    public void setCompletionName(String completionName) {
        this.completionName = completionName;
    }

    public List<CarOption> getCarOptions() {
        return carOptions;
    }

    public void setCarOptions(List<CarOption> carOptions) {
        this.carOptions = carOptions;
    }

    @Override
    public String toString() {
        return "Completion{" +
                "completionId=" + completionId +
                ", completionName='" + completionName + '\'' +
                ", carOptions=" + carOptions +
                '}';
    }
}
