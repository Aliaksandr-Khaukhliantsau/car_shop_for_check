package service.impl;

import entity.CarOption;
import entity.Completion;
import repository.CompletionRepository;
import repository.impl.CompletionRepositoryImpl;
import service.CarOptionService;
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
    public Completion getCompletionByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet = completionRepository.getCompletionByCompletionId(completionId);
        Completion completion = new Completion();

        while (resultSet.next()) {
            completion.setCompletionId(UUID.fromString(resultSet.getString("id")));
            completion.setCompletionName(resultSet.getString("name"));
            CarOptionService carOptionService = new CarOptionServiceImpl();
            List<CarOption> carOptionList = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("id")));
            completion.setCarOptions(carOptionList);

        }
        return completion;
    }

    @Override
    public Completion getCompletionByCompletionName(String completionName) throws SQLException {
        ResultSet resultSet = completionRepository.getCompletionByCompletionName(completionName);
        Completion completion = new Completion();

        while (resultSet.next()) {
            completion.setCompletionId(UUID.fromString(resultSet.getString("id")));
            completion.setCompletionName(resultSet.getString("name"));
            CarOptionService carOptionService = new CarOptionServiceImpl();
            List<CarOption> carOptionList = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("id")));
            completion.setCarOptions(carOptionList);
        }
        return completion;
    }

    @Override
    public List<Completion> getAllCompletions() throws SQLException {
        ResultSet resultSet = completionRepository.getAllCompletions();
        List<Completion> completionList = new ArrayList<>();

        while (resultSet.next()) {
            Completion completion = new Completion();
            completion.setCompletionId(UUID.fromString(resultSet.getString("id")));
            completion.setCompletionName(resultSet.getString("name"));
            CarOptionService carOptionService = new CarOptionServiceImpl();
            List<CarOption> carOptionList = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("id")));
            completion.setCarOptions(carOptionList);

            completionList.add(completion);
        }
        return completionList;
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

//    @Override
//    public void addCarOption(Completion completion, UUID optionId) throws SQLException {
//        completionRepository.addCarOption(completion.getCompletionId(), optionId);
//        CarOptionService carOptionService = new CarOptionServiceImpl();
//        CarOption carOption = carOptionService.getCarOptionByOptionId(optionId);
//        completion.addCarOption(carOption);
//
//    }

    @Override
    public void addCarOption(UUID completionId, UUID optionId) throws SQLException {
        completionRepository.addCarOption(completionId, optionId);
    }
}
