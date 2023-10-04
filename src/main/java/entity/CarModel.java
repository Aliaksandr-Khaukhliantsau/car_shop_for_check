package entity;

import java.util.UUID;

public class CarModel {
    private UUID modelId;
    private String modelName;
    private UUID completionId;

    public CarModel() {
    }

    public CarModel(UUID modelId, String modelName, UUID completionId) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.completionId = completionId;
    }

    public UUID getModelId() {
        return modelId;
    }

    public void setModelId(UUID modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public UUID getCompletionId() {
        return completionId;
    }

    public void setCompletionId(UUID completionId) {
        this.completionId = completionId;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", completionId=" + completionId +
                '}';
    }
}
