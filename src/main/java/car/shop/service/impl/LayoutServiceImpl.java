package car.shop.service.impl;

import car.shop.dto.LayoutDto;
import car.shop.entity.Completion;
import car.shop.entity.Layout;
import car.shop.mapper.LayoutMapper;
import car.shop.repository.CompletionRepository;
import car.shop.repository.LayoutRepository;
import car.shop.service.LayoutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LayoutServiceImpl implements LayoutService {
    private final LayoutRepository layoutRepository;
    private final CompletionRepository completionRepository;
    private final LayoutMapper layoutMapper;

    @Override
    @Transactional
    public LayoutDto getById(UUID id) {
        Layout layout = layoutRepository.findById(id).orElse(null);
        return layoutMapper.layoutToLayoutDto(layout);
    }

    @Override
    @Transactional
    public List<LayoutDto> getByLayoutName(String layoutName) {
        return layoutRepository.findByLayoutName(layoutName).stream().map(layoutMapper::layoutToLayoutDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<LayoutDto> getByCompletionId(UUID completionId) {
//        return layoutRepository.findByCompletions_Id(completionId).stream().map(layoutMapper::layoutToLayoutDto).collect(Collectors.toList());
        return layoutRepository.findByCompletionId(completionId).stream().map(layoutMapper::layoutToLayoutDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<LayoutDto> getAll() {
        return layoutRepository.findAll().stream().map(layoutMapper::layoutToLayoutDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(String layoutName, UUID completionId) {
        Completion completion = completionRepository.findById(completionId).orElse(null);
        if (completion != null) {
            Layout layout = new Layout();
            layout.setLayoutName(layoutName);
            layout.setCompletionId(completionId);
            layout.getCompletions().add(completion);
            completion.setLayout(layout);
            layoutRepository.save(layout);
        }
    }

    @Override
    @Transactional
    public void update(UUID id, String layoutName, UUID completionId) {
        Completion completion = completionRepository.findById(completionId).orElse(null);
        Layout layout = layoutRepository.findById(id).orElse(null);
        if (layout != null && completion != null) {
            layout.setLayoutName(layoutName);
            layout.setCompletionId(completionId);
            layout.getCompletions().add(completion);
            completion.setLayout(layout);
            layoutRepository.save(layout);
        }
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Layout layout = layoutRepository.findById(id).orElse(null);
        if (layout != null) {
            for (Completion completion : layout.getCompletions()) {
                completion.setLayout(null);
            }
            layoutRepository.delete(layout);
        }
    }
}
