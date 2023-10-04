package service.impl;

import entity.Completion;
import repository.CompletionRepository;
import repository.impl.CompletionRepositoryImpl;
import service.CompletionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompletionServiceImpl implements CompletionService {
    CompletionRepository completionRepository = new CompletionRepositoryImpl();

    public CompletionServiceImpl() throws SQLException {
    }

    @Override
    public List<Completion> getCompletionByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet = completionRepository.getCompletionByCompletionId(completionId);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setCompletionId(resultSet.getString("id"));
            completion.setCompletionName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> getCompletionByCompletionName(String completionName) throws SQLException {
        ResultSet resultSet = completionRepository.getCompletionByCompletionName(completionName);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setCompletionId(resultSet.getString("id"));
            completion.setCompletionName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> getAllCompletions() throws SQLException {
        ResultSet resultSet = completionRepository.getAllCompletions();
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setCompletionId(resultSet.getString("id"));
            completion.setCompletionName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> create(String completionName) throws SQLException {
        ResultSet resultSet = completionRepository.create(completionName);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setCompletionId(resultSet.getString("id"));
            completion.setCompletionName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> update(UUID CompletionId, String completionName) throws SQLException {
        ResultSet resultSet = completionRepository.update(CompletionId, completionName);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setCompletionId(resultSet.getString("id"));
            completion.setCompletionName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> delete(UUID CompletionId) throws SQLException {
        ResultSet resultSet = completionRepository.delete(CompletionId);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setCompletionId(resultSet.getString("id"));
            completion.setCompletionName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }
}
