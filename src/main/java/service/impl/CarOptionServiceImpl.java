package service.impl;

import dto.CarOptionDto;
import mapper.CarOptionMapper;
import repository.CarOptionRepository;
import repository.impl.CarOptionRepositoryImpl;
import service.CarOptionService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarOptionServiceImpl implements CarOptionService {
    private static final CarOptionMapper carOptionMapper = CarOptionMapper.INSTANCE;

    CarOptionRepository carOptionRepository = new CarOptionRepositoryImpl();

    public CarOptionServiceImpl() throws SQLException {
    }

    @Override
    public CarOptionDto getCarOptionByOptionId(UUID optionId) throws SQLException {
        return carOptionMapper.carOptionToCarOptionDto(carOptionRepository.getCarOptionByOptionId(optionId));

    }

    @Override
    public CarOptionDto getCarOptionByOptionName(String optionName) throws SQLException {
        return carOptionMapper.carOptionToCarOptionDto(carOptionRepository.getCarOptionByOptionName(optionName));
    }

    @Override
    public List<CarOptionDto> getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        return carOptionRepository.getCarOptionsByCompletionId(completionId).stream().map(carOptionMapper::carOptionToCarOptionDto).collect(Collectors.toList());
    }

    @Override
    public List<CarOptionDto> getAllCarOptions() throws SQLException {
        return carOptionRepository.getAllCarOptions().stream().map(carOptionMapper::carOptionToCarOptionDto).collect(Collectors.toList());
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
