package car.shop.service;

import car.shop.dto.LayoutDto;

import java.util.List;
import java.util.UUID;

public interface LayoutService {
    LayoutDto getById(UUID id);

    List<LayoutDto> getByLayoutName(String layoutName);

        List<LayoutDto> getByCompletionId(UUID completionId);
//    LayoutDto getByCompletionId(UUID completionId);

    List<LayoutDto> getAll();

    void create(String layoutName, UUID completionId);

    void update(UUID id, String layoutName, UUID completionId);

    void delete(UUID id);
}
