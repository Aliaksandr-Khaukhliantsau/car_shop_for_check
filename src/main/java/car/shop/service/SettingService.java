package car.shop.service;

import car.shop.dto.SettingDto;

import java.util.List;
import java.util.UUID;

public interface SettingService {

    SettingDto getById(UUID id);

    SettingDto getBySettingName(String settingName);

    List<SettingDto> getAll();

    void create(String settingName);

    void update(UUID id, String settingName);

    void delete(UUID id);
}
