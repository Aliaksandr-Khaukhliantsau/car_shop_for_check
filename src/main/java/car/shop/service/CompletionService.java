package car.shop.service;

import car.shop.dto.CompletionDto;

import java.util.List;
import java.util.UUID;

public interface CompletionService {
    CompletionDto getById(UUID id);

    CompletionDto getByCompletionName(String completionName);

    List<CompletionDto> getAll();

    void addSettingToCompletion(UUID completionId, UUID settingId);

    void removeSettingFromCompletion(UUID completionId, UUID settingId);

    void create(String completionName);

    void update(UUID id, String completionName);

    void delete(UUID id);
}
