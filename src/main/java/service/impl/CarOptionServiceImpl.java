package service.impl;

import entity.CarOption;
import repository.CarOptionRepository;
import repository.impl.CarOptionRepositoryImpl;
import service.CarOptionService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CarOptionServiceImpl implements CarOptionService {
    CarOptionRepository carOptionRepository = new CarOptionRepositoryImpl();

    public CarOptionServiceImpl() throws SQLException {
    }

    @Override
    public CarOption getCarOptionByOptionId(UUID optionId) throws SQLException {
        return carOptionRepository.getCarOptionByOptionId(optionId);

    }

    @Override
    public CarOption getCarOptionByOptionName(String optionName) throws SQLException {
        return carOptionRepository.getCarOptionByOptionName(optionName);
    }

    @Override
    public List<CarOption> getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        return carOptionRepository.getCarOptionsByCompletionId(completionId);
    }

    @Override
    public List<CarOption> getAllCarOptions() throws SQLException {
        return carOptionRepository.getAllCarOptions();
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
