package service.impl;

import entity.CarOption;
import repository.CarOptionRepository;
import repository.impl.CarCarOptionRepositoryImpl;
import service.CarOptionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarOptionServiceImpl implements CarOptionService {
    CarOptionRepository carOptionRepository = new CarCarOptionRepositoryImpl();

    public CarOptionServiceImpl() throws SQLException {
    }

    @Override
    public List<CarOption> getCarOptionByOptionId(UUID optionId) throws SQLException {
        ResultSet resultSet = carOptionRepository.getCarOptionByOptionId(optionId);
        List<CarOption> carOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(resultSet.getString("id"));
            carOption.setOptionName(resultSet.getString("name"));

            carOptionList.add(carOption);
        }
        return carOptionList;
    }

    @Override
    public List<CarOption> getCarOptionByOptionName(String optionName) throws SQLException {
        ResultSet resultSet = carOptionRepository.getCarOptionByOptionName(optionName);
        List<CarOption> carOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(resultSet.getString("id"));
            carOption.setOptionName(resultSet.getString("name"));

            carOptionList.add(carOption);
        }
        return carOptionList;
    }

    @Override
    public List<CarOption> getAllCarOptions() throws SQLException {
        ResultSet resultSet = carOptionRepository.getAllCarOptions();
        List<CarOption> carOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(resultSet.getString("id"));
            carOption.setOptionName(resultSet.getString("name"));

            carOptionList.add(carOption);
        }
        return carOptionList;
    }

    @Override
    public List<CarOption> create(String optionName) throws SQLException {
        ResultSet resultSet = carOptionRepository.create(optionName);
        List<CarOption> carOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(resultSet.getString("id"));
            carOption.setOptionName(resultSet.getString("name"));

            carOptionList.add(carOption);
        }
        return carOptionList;
    }

    @Override
    public List<CarOption> update(UUID optionId, String optionName) throws SQLException {
        ResultSet resultSet = carOptionRepository.update(optionId, optionName);
        List<CarOption> carOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(resultSet.getString("id"));
            carOption.setOptionName(resultSet.getString("name"));

            carOptionList.add(carOption);
        }
        return carOptionList;
    }

    @Override
    public List<CarOption> delete(UUID optionId) throws SQLException {
        ResultSet resultSet = carOptionRepository.delete(optionId);
        List<CarOption> carOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CarOption carOption = new CarOption();
            carOption.setOptionId(resultSet.getString("id"));
            carOption.setOptionName(resultSet.getString("name"));

            carOptionList.add(carOption);
        }
        return carOptionList;
    }
}
