package car.shop.service;

import car.shop.dto.SettingDto;
import car.shop.entity.Setting;

import java.util.List;
import java.util.UUID;

public interface SettingService {

    SettingDto getById(UUID id);

    SettingDto getBySettingName(String settingName);

    List<SettingDto> getAll();

    void create(Setting setting);

    void update(Setting setting);

    void delete(UUID id);
}
