package service.impl;

import entity.Option;
import repository.OptionRepository;
import repository.impl.OptionRepositoryImpl;
import service.OptionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OptionServiceImpl implements OptionService {
    OptionRepository optionRepository = new OptionRepositoryImpl();

    public OptionServiceImpl() throws SQLException {
    }

    @Override
    public List<Option> getById(String id) throws SQLException {
        ResultSet resultSet = optionRepository.getById(id);
        List<Option> optionList = new ArrayList<>();

        while (resultSet.next()) {
            Option option = new Option();
            option.setId(resultSet.getString("id"));
            option.setName(resultSet.getString("name"));

            optionList.add(option);
        }
        return optionList;
    }

    @Override
    public List<Option> getByName(String name) throws SQLException {
        ResultSet resultSet = optionRepository.getByName(name);
        List<Option> optionList = new ArrayList<>();

        while (resultSet.next()) {
            Option option = new Option();
            option.setId(resultSet.getString("id"));
            option.setName(resultSet.getString("name"));

            optionList.add(option);
        }
        return optionList;
    }

    @Override
    public List<Option> getAllOptions() throws SQLException {
        ResultSet resultSet = optionRepository.getAllOptions();
        List<Option> optionList = new ArrayList<>();

        while (resultSet.next()) {
            Option option = new Option();
            option.setId(resultSet.getString("id"));
            option.setName(resultSet.getString("name"));

            optionList.add(option);
        }
        return optionList;
    }

    @Override
    public List<Option> create(String name) throws SQLException {
        ResultSet resultSet = optionRepository.create(name);
        List<Option> optionList = new ArrayList<>();

        while (resultSet.next()) {
            Option option = new Option();
            option.setId(resultSet.getString("id"));
            option.setName(resultSet.getString("name"));

            optionList.add(option);
        }
        return optionList;
    }

    @Override
    public List<Option> update(String id, String name) throws SQLException {
        ResultSet resultSet = optionRepository.update(id, name);
        List<Option> optionList = new ArrayList<>();

        while (resultSet.next()) {
            Option option = new Option();
            option.setId(resultSet.getString("id"));
            option.setName(resultSet.getString("name"));

            optionList.add(option);
        }
        return optionList;
    }

    @Override
    public List<Option> delete(String id) throws SQLException {
        ResultSet resultSet = optionRepository.delete(id);
        List<Option> optionList = new ArrayList<>();

        while (resultSet.next()) {
            Option option = new Option();
            option.setId(resultSet.getString("id"));
            option.setName(resultSet.getString("name"));

            optionList.add(option);
        }
        return optionList;
    }
}
