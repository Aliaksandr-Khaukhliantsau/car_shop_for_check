package car.shop.service.impl;

import car.shop.dto.CompletionDto;
import car.shop.entity.Completion;
import car.shop.entity.Setting;
import car.shop.mapper.CompletionMapper;
import car.shop.repository.CompletionRepository;
import car.shop.repository.SettingRepository;
import car.shop.service.CompletionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CompletionServiceImpl implements CompletionService {
    private final CompletionRepository completionRepository;
    private final SettingRepository settingRepository;
    private final CompletionMapper completionMapper;

    @Override
    @Transactional
    public CompletionDto getById(UUID id) {
        return completionMapper.completionToCompletionDto(completionRepository.getById(id));
    }

    @Override
    @Transactional
    public CompletionDto getByCompletionName(String completionName) {
        return completionMapper.completionToCompletionDto(completionRepository.getByCompletionName(completionName));
    }

    @Override
    @Transactional
    public List<CompletionDto> getAll() {
        return completionRepository.findAll().stream()
                .map(completionMapper::completionToCompletionDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addSettingToCompletion(UUID completionId, UUID settingId) {
        Completion completion = completionRepository.getById(completionId);
        Setting setting = settingRepository.getById(settingId);

        if (completion != null && setting != null) {
            completion.getSettings().add(setting);
            completionRepository.save(completion);
        }
    }

    @Override
    @Transactional
    public void removeSettingFromCompletion(UUID completionId, UUID settingId) {
        Completion completion = completionRepository.getById(completionId);
        Setting setting = settingRepository.getById(settingId);

        if (completion != null && setting != null) {
            completion.getSettings().remove(setting);
            completionRepository.save(completion);
        }
    }

    @Override
    @Transactional
    public void create(String completionName) {
        Completion completion = new Completion();
        completion.setCompletionName(completionName);
        completionRepository.save(completion);
    }

    @Override
    @Transactional
    public void update(UUID id, String completionName) {
        Completion completion = completionRepository.getById(id);

        if (completion != null) {
            completion.setCompletionName(completionName);
            completionRepository.save(completion);
        }
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        completionRepository.deleteById(id);
    }
}
