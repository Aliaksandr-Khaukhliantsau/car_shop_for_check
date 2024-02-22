package car.shop.service.impl;

import car.shop.dto.SettingDto;
import car.shop.entity.Setting;
import car.shop.mapper.SettingMapper;
import car.shop.repository.SettingRepository;
import car.shop.service.SettingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SettingServiceImpl implements SettingService {
    private final SettingRepository settingRepository;
    private final SettingMapper settingMapper;

    @Override
    @Transactional
    public SettingDto getById(UUID id) {
        return settingMapper.settingToSettingDto(settingRepository.getById(id));
    }

    @Override
    @Transactional
    public SettingDto getBySettingName(String settingName) {
        return settingMapper.settingToSettingDto(settingRepository.getBySettingName(settingName));
    }

    @Override
    @Transactional
    public List<SettingDto> getAll() {
        return settingRepository.findAll().stream()
                .map(settingMapper::settingToSettingDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(String settingName) {
        Setting setting = new Setting();
        setting.setSettingName(settingName);
        settingRepository.save(setting);
    }

    @Override
    @Transactional
    public void update(UUID id, String settingName) {
        Setting setting = settingRepository.getById(id);
        if (setting != null) {
            setting.setSettingName(settingName);
            settingRepository.save(setting);
        }
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        settingRepository.deleteById(id);
    }
}
