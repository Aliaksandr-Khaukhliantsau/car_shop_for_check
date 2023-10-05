package service.impl;

import entity.CompletionCarOption;
import repository.CompletionCarOptionRepository;
import repository.impl.CompletionCarOptionRepositoryImpl;
import service.CompletionCarOptionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompletionCarOptionServiceImpl implements CompletionCarOptionService {
    CompletionCarOptionRepository completionCarOptionRepository = new CompletionCarOptionRepositoryImpl();

    public CompletionCarOptionServiceImpl() throws SQLException {
    }

    @Override
    public List<CompletionCarOption> getCompletionCarOptionByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet = completionCarOptionRepository.getCompletionCarOptionByCompletionId(completionId);
        List<CompletionCarOption> completionCarOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionCarOption completionCarOption = new CompletionCarOption();
            completionCarOption.setCompletionId(UUID.fromString(resultSet.getString("idcompletion")));
            completionCarOption.setOptionId(UUID.fromString(resultSet.getString("idoption")));

            completionCarOptionList.add(completionCarOption);
        }
        return completionCarOptionList;
    }

    @Override
    public List<CompletionCarOption> getCompletionCarOptionByOptionId(UUID optionId) throws SQLException {
        ResultSet resultSet = completionCarOptionRepository.getCompletionCarOptionByOptionId(optionId);
        List<CompletionCarOption> completionCarOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionCarOption completionCarOption = new CompletionCarOption();
            completionCarOption.setCompletionId(UUID.fromString(resultSet.getString("idcompletion")));
            completionCarOption.setOptionId(UUID.fromString(resultSet.getString("idoption")));

            completionCarOptionList.add(completionCarOption);
        }
        return completionCarOptionList;
    }

    @Override
    public List<CompletionCarOption> getAllCompletionCarOptions() throws SQLException {
        ResultSet resultSet = completionCarOptionRepository.getAllCompletionCarOptions();
        List<CompletionCarOption> completionCarOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionCarOption completionCarOption = new CompletionCarOption();
            completionCarOption.setCompletionId(UUID.fromString(resultSet.getString("idcompletion")));
            completionCarOption.setOptionId(UUID.fromString(resultSet.getString("idoption")));

            completionCarOptionList.add(completionCarOption);
        }
        return completionCarOptionList;
    }

    @Override
    public void create(UUID completionId, UUID optionId) throws SQLException {
        completionCarOptionRepository.create(completionId, optionId);
    }

    @Override
    public void delete(UUID completionId, UUID optionId) throws SQLException {
        completionCarOptionRepository.delete(completionId, optionId);
    }
}
