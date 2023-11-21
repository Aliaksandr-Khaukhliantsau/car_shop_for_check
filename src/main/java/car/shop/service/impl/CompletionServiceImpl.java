package car.shop.service.impl;

import car.shop.dto.CompletionDto;
import car.shop.entity.Completion;
import car.shop.entity.Setting;
import car.shop.mapper.CompletionMapper;
import car.shop.repository.CompletionRepository;
import car.shop.repository.SettingRepository;
import car.shop.service.CompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompletionServiceImpl implements CompletionService {
    private final CompletionRepository completionRepository;
    private final SettingRepository settingRepository;
    private final CompletionMapper completionMapper;

    @Autowired
    public CompletionServiceImpl(CompletionRepository completionRepository, SettingRepository settingRepository, CompletionMapper completionMapper) {
        this.completionRepository = completionRepository;
        this.settingRepository = settingRepository;
        this.completionMapper = completionMapper;
    }

    @Override
    public CompletionDto getById(UUID id) {
        Completion completion = completionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid completion id"));
        return completionMapper.completionToCompletionDto(completion);
    }

    @Override
    public CompletionDto getByCompletionName(String completionName) {
        Completion completion = completionRepository.findByCompletionName(completionName).orElseThrow(() -> new IllegalArgumentException("Invalid completion name"));
        return completionMapper.completionToCompletionDto(completion);
    }

    @Override
    public List<CompletionDto> getAll() {
        return completionRepository.findAll().stream().map(completionMapper::completionToCompletionDto).collect(Collectors.toList());
    }

    @Override
    public void addSettingToCompletion(UUID completionId, UUID settingId) {
        Completion completion = completionRepository.findById(completionId).orElseThrow(() -> new IllegalArgumentException("Invalid completion id"));
        Setting setting = settingRepository.findById(settingId).orElseThrow(() -> new IllegalArgumentException("Invalid setting id"));
        completion.getSettings().add(setting);
        completionRepository.save(completion);
    }

    @Override
    public void removeSettingFromCompletion(UUID completionId, UUID settingId) {
        Completion completion = completionRepository.findById(completionId).orElseThrow(() -> new IllegalArgumentException("Invalid completion id"));
        Setting setting = settingRepository.findById(settingId).orElseThrow(() -> new IllegalArgumentException("Invalid setting id"));
        completion.getSettings().remove(setting);
//        setting.getCompletions().remove(completion);
//        settingRepository.save(setting);
        completionRepository.save(completion);
    }

    @Override
    public void create(String completionName) {
        Completion completion = new Completion();
        completion.setCompletionName(completionName);
        completionRepository.save(completion);
    }

    @Override
    public void update(UUID id, String completionName) {
        Completion completion = completionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid completion id"));
        completion.setCompletionName(completionName);
        completionRepository.save(completion);
    }

    @Override
    public void delete(UUID id) {
        completionRepository.deleteById(id);
    }
}
