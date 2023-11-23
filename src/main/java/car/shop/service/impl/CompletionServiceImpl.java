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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class CompletionServiceImpl implements CompletionService {
    private final CompletionRepository completionRepository;
    private final SettingRepository settingRepository;
    private final CompletionMapper completionMapper;

//    @Autowired
//    private EntityManager entityManager;

    @Autowired
    public CompletionServiceImpl(CompletionRepository completionRepository, SettingRepository settingRepository, CompletionMapper completionMapper) {
        this.completionRepository = completionRepository;
        this.settingRepository = settingRepository;
        this.completionMapper = completionMapper;
    }

    @Override
    public CompletionDto getById(UUID id) {
        Completion completion = completionRepository.findById(id).orElse(null);
        return completionMapper.completionToCompletionDto(completion);
    }

    @Override
    public CompletionDto getByCompletionName(String completionName) {
        Completion completion = completionRepository.findByCompletionName(completionName).orElse(null);
        return completionMapper.completionToCompletionDto(completion);
    }

    @Override
    public List<CompletionDto> getAll() {
        return completionRepository.findAll().stream().map(completionMapper::completionToCompletionDto).collect(Collectors.toList());
    }

    @Override
    public void addSettingToCompletion(UUID completionId, UUID settingId) {
        Completion completion = completionRepository.findById(completionId).orElse(null);
        Setting setting = settingRepository.findById(settingId).orElse(null);

        if (completion != null && setting != null) {
            completion.getSettings().add(setting);
//            setting.getCompletions().add(completion);
            completionRepository.save(completion);
//            settingRepository.save(setting);
        }
    }

    @Override
    public void removeSettingFromCompletion(UUID completionId, UUID settingId) {
        Completion completion = completionRepository.findById(completionId).orElse(null);
        Setting setting = settingRepository.findById(settingId).orElse(null);

        if (completion != null && setting != null) {
            completion.getSettings().remove(setting);
//            setting.getCompletions().remove(completion);
            completionRepository.save(completion);
//            settingRepository.save(setting);
//            entityManager.flush();
        }
    }

    @Override
    public void create(String completionName) {
        Completion completion = new Completion();
        completion.setCompletionName(completionName);
        completionRepository.save(completion);
    }

    @Override
    public void update(UUID id, String completionName) {
        Completion completion = completionRepository.findById(id).orElse(null);

        if (completion != null) {
            completion.setCompletionName(completionName);
            completionRepository.save(completion);
        }
    }

    @Override
    public void delete(UUID id) {
        completionRepository.deleteById(id);
    }
}
