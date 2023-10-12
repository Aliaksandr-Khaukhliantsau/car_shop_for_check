package service.impl;

import dto.CarModelDto;
import mapper.CarModelMapper;
import repository.CarModelRepository;
import repository.impl.CarModelRepositoryImpl;
import service.CarModelService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarModelServiceImpl implements CarModelService {
    private static final CarModelMapper carModelMapper = mapper.CarModelMapper.INSTANCE;

    CarModelRepository carModelRepository = new CarModelRepositoryImpl();

    public CarModelServiceImpl() throws SQLException {
    }

    @Override
    public CarModelDto getCarModelByModelId(UUID modelId) throws SQLException {
        return carModelMapper.carModelToCarModelDto(carModelRepository.getCarModelByModelId(modelId));
    }

    @Override
    public List<CarModelDto> getCarModelByModelName(String modelName) throws SQLException {
        return carModelRepository.getCarModelByModelName(modelName).stream().map(carModelMapper::carModelToCarModelDto).collect(Collectors.toList());
    }

    @Override
    public List<CarModelDto> getCarModelByCompletionId(UUID completionId) throws SQLException {
        return carModelRepository.getCarModelByCompletionId(completionId).stream().map(carModelMapper::carModelToCarModelDto).collect(Collectors.toList());
    }

    @Override
    public List<CarModelDto> getAllCarModels() throws SQLException {
        return carModelRepository.getAllCarModels().stream().map(carModelMapper::carModelToCarModelDto).collect(Collectors.toList());
    }

    @Override
    public void create(String modelName, UUID completionId) throws SQLException {
        carModelRepository.create(modelName, completionId);
    }

    @Override
    public void update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        carModelRepository.update(modelId, modelName, completionId);
    }

    @Override
    public void delete(UUID modelId) throws SQLException {
        carModelRepository.delete(modelId);
    }
}
