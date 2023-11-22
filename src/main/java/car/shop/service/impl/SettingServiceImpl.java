package car.shop.service.impl;

import car.shop.dto.SettingDto;
import car.shop.entity.Setting;
import car.shop.mapper.SettingMapper;
import car.shop.repository.SettingRepository;
import car.shop.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class SettingServiceImpl implements SettingService {
    private final SettingRepository settingRepository;
    private final SettingMapper settingMapper;

    @Autowired
    public SettingServiceImpl(SettingRepository settingRepository, SettingMapper settingMapper) {
        this.settingRepository = settingRepository;
        this.settingMapper = settingMapper;
    }

    @Override
    public SettingDto getById(UUID id) {
        Setting setting = settingRepository.findById(id).orElse(null);
        return settingMapper.settingToSettingDto(setting);
    }

    @Override
    public SettingDto getBySettingName(String settingName) {
        Setting setting = settingRepository.findBySettingName(settingName).orElse(null);
        return settingMapper.settingToSettingDto(setting);
    }

    @Override
    public List<SettingDto> getAll() {
        return settingRepository.findAll().stream().map(settingMapper::settingToSettingDto).collect(Collectors.toList());
    }

    @Override
    public void create(String settingName) {
        Setting setting = new Setting();
        setting.setSettingName(settingName);
        settingRepository.save(setting);
    }

    @Override
    public void update(UUID id, String settingName) {
        Setting setting = settingRepository.findById(id).orElse(null);
        if (setting != null) {
            setting.setSettingName(settingName);
            settingRepository.save(setting);
        }
    }

    @Override
    public void delete(UUID id) {
        settingRepository.deleteById(id);
    }
}
