package entity;

import java.util.UUID;

public class CarModel {
    private UUID modelId;
    private String modelName;
    private Completion completion;

    public CarModel() {
    }

    public CarModel(UUID modelId, String modelName, Completion completion) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.completion = completion;
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

    public Completion getCompletion() {
        return completion;
    }

    public void setCompletion(Completion completion) {
        this.completion = completion;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", completion=" + completion +
                '}';
    }
}
