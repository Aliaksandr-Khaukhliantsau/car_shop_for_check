package service.impl;

import entity.Completion;
import repository.CompletionRepository;
import repository.impl.CompletionRepositoryImpl;
import service.CompletionService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CompletionServiceImpl implements CompletionService {
    CompletionRepository completionRepository = new CompletionRepositoryImpl();

    public CompletionServiceImpl() throws SQLException {
    }

    @Override
    public Completion getCompletionByCompletionId(UUID completionId) throws SQLException {
        return completionRepository.getCompletionByCompletionId(completionId);
    }

    @Override
    public Completion getCompletionByCompletionName(String completionName) throws SQLException {
        return completionRepository.getCompletionByCompletionName(completionName);
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
    public List<Completion> getAllCompletions() throws SQLException {
        return completionRepository.getAllCompletions();
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
