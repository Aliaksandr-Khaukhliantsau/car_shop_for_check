package entity;

import java.util.UUID;

public class CompletionCarOption {
    private UUID completionId;
    private UUID optionId;

    public CompletionCarOption() {
    }

    public CompletionCarOption(UUID completionId, UUID optionId) {
        this.completionId = completionId;
        this.optionId = optionId;
    }

    public UUID getCompletionId() {
        return completionId;
    }

    public void setCompletionId(UUID completionId) {
        this.completionId = completionId;
    }

    public UUID getOptionId() {
        return optionId;
    }

    public void setOptionId(UUID optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "CompletionCarOption{" +
                "completionId=" + completionId +
                ", optionId=" + optionId +
                '}';
    }
}
