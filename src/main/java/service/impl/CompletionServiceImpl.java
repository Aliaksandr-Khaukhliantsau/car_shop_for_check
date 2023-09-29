package service.impl;

import entity.Completion;
import repository.CompletionRepository;
import repository.impl.CompletionRepositoryImpl;
import service.CompletionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompletionServiceImpl implements CompletionService {
    CompletionRepository completionRepository = new CompletionRepositoryImpl();

    public CompletionServiceImpl() throws SQLException {
    }

    @Override
    public List<Completion> getById(String id) throws SQLException {
        ResultSet resultSet = completionRepository.getById(id);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setId(resultSet.getString("id"));
            completion.setName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> getByName(String name) throws SQLException {
        ResultSet resultSet = completionRepository.getByName(name);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setId(resultSet.getString("id"));
            completion.setName(resultSet.getString("name"));

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
            completion.setId(resultSet.getString("id"));
            completion.setName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> create(String name) throws SQLException {
        ResultSet resultSet = completionRepository.create(name);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setId(resultSet.getString("id"));
            completion.setName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> update(String id, String name) throws SQLException {
        ResultSet resultSet = completionRepository.update(id, name);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setId(resultSet.getString("id"));
            completion.setName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }

    @Override
    public List<Completion> delete(String id) throws SQLException {
        ResultSet resultSet = completionRepository.delete(id);
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setId(resultSet.getString("id"));
            completion.setName(resultSet.getString("name"));

            completionList.add(completion);
        }
        return completionList;
    }
}
