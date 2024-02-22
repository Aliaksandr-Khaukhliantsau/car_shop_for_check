package car.shop.service;

import car.shop.dto.CompletionDto;
import car.shop.entity.Completion;

import java.util.List;
import java.util.UUID;

public interface CompletionService {
    CompletionDto getById(UUID id);

    CompletionDto getByCompletionName(String completionName);

    List<CompletionDto> getAll();

    void addSetting(UUID completionId, UUID settingId);

    void removeSetting(UUID completionId, UUID settingId);

    void create(Completion completion);

    void update(Completion completion);

    void delete(UUID id);
}
