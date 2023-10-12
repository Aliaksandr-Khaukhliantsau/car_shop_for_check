package service.impl;

import dto.CarDto;
import mapper.CarMapper;
import repository.CarRepository;
import repository.impl.CarRepositoryImpl;
import service.CarService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    private static final CarMapper carMapper = CarMapper.INSTANCE;

    CarRepository carRepository = new CarRepositoryImpl();

    public CarServiceImpl() throws SQLException {
    }

    @Override
    public CarDto getCarByCarId(UUID carId) throws SQLException {
        return carMapper.carToCarDto(carRepository.getCarByCarId(carId));
    }

    @Override
    public CarDto getCarByVin(String vin) throws SQLException {
        return carMapper.carToCarDto(carRepository.getCarByVin(vin));
    }

    @Override
    public List<CarDto> getCarByModelId(UUID modelId) throws SQLException {
        return carRepository.getCarByModelId(modelId).stream().map(carMapper::carToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getAllCars() throws SQLException {
        return carRepository.getAllCars().stream().map(carMapper::carToCarDto).collect(Collectors.toList());
    }

    @Override
    public void create(String vin, UUID modelId) throws SQLException {
        carRepository.create(vin, modelId);
    }

    @Override
    public void update(UUID carId, String vin, UUID modelId) throws SQLException {
        carRepository.update(carId, vin, modelId);
    }

    @Override
    public void delete(UUID carId) throws SQLException {
        carRepository.delete(carId);
    }
}
