package service.impl;

import entity.CarOption;
import repository.CarOptionRepository;
import repository.impl.CarOptionRepositoryImpl;
import service.CarOptionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarOptionServiceImpl implements CarOptionService {
    CarOptionRepository carOptionRepository = new CarOptionRepositoryImpl();

    public CarOptionServiceImpl() throws SQLException {
    }

    @Override
    public CarOption getCarOptionByOptionId(UUID optionId) throws SQLException {
        ResultSet resultSet = carOptionRepository.getCarOptionByOptionId(optionId);
        CarOption carOption = new CarOption();

        while (resultSet.next()) {
            carOption.setOptionId(UUID.fromString(resultSet.getString("id")));
            carOption.setOptionName(resultSet.getString("name"));
        }
        return carOption;
    }

    @Override
    public CarOption getCarOptionByOptionName(String optionName) throws SQLException {
        ResultSet resultSet = carOptionRepository.getCarOptionByOptionName(optionName);
        CarOption carOption = new CarOption();

        while (resultSet.next()) {
            carOption.setOptionId(UUID.fromString(resultSet.getString("id")));
            carOption.setOptionName(resultSet.getString("name"));
        }
        return carOption;
    }

    @Override
    public List<CarOption> getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet = carOptionRepository.getCarOptionsByCompletionId(completionId);
        List<CarOption> carOptions = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(UUID.fromString(resultSet.getString("id")));
            carOption.setOptionName(resultSet.getString("name"));

            carOptions.add(carOption);
        }
        return carOptions;
    }

    @Override
    public List<CarOption> getAllCarOptions() throws SQLException {
        ResultSet resultSet = carOptionRepository.getAllCarOptions();
        List<CarOption> carOptions = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(UUID.fromString(resultSet.getString("id")));
            carOption.setOptionName(resultSet.getString("name"));

            carOptions.add(carOption);
        }
        return carOptions;
    }

    @Override
    public void create(String optionName) throws SQLException {
        carOptionRepository.create(optionName);
    }

    @Override
    public void update(UUID optionId, String optionName) throws SQLException {
        carOptionRepository.update(optionId, optionName);
    }

    @Override
    public void delete(UUID optionId) throws SQLException {
        carOptionRepository.delete(optionId);
    }
}
