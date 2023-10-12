package service.impl;

import dto.CompletionDto;
import mapper.CompletionMapper;
import repository.CompletionRepository;
import repository.impl.CompletionRepositoryImpl;
import service.CompletionService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CompletionServiceImpl implements CompletionService {
    private static final CompletionMapper completionMapper = CompletionMapper.INSTANCE;

    CompletionRepository completionRepository = new CompletionRepositoryImpl();

    public CompletionServiceImpl() throws SQLException {
    }

    @Override
    public CompletionDto getCompletionByCompletionId(UUID completionId) throws SQLException {
        return completionMapper.completionToCompletionDto(completionRepository.getCompletionByCompletionId(completionId));
    }

    @Override
    public CompletionDto getCompletionByCompletionName(String completionName) throws SQLException {
        return completionMapper.completionToCompletionDto(completionRepository.getCompletionByCompletionName(completionName));
    }

    @Override
    public List<CompletionDto> getAllCompletions() throws SQLException {
        return completionRepository.getAllCompletions().stream().map(completionMapper::completionToCompletionDto).collect(Collectors.toList());
    }

    @Override
    public void addCarOption(UUID completionId, UUID optionId) throws SQLException {
        completionRepository.addCarOption(completionId, optionId);
    }

    @Override
    public void deleteCarOption(UUID completionId, UUID optionId) throws SQLException {
        completionRepository.deleteCarOption(completionId, optionId);
    }

    @Override
    public void create(String completionName) throws SQLException {
        completionRepository.create(completionName);
    }

    @Override
    public void update(UUID CompletionId, String completionName) throws SQLException {
        completionRepository.update(CompletionId, completionName);
    }

    @Override
    public void delete(UUID CompletionId) throws SQLException {
        completionRepository.delete(CompletionId);
    }
}
