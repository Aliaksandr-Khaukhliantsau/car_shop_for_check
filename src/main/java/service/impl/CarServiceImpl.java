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

/**
 * Implementation of the CarService interface.
 * This class provides methods to interact with car data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CarServiceImpl implements CarService {
    private static final CarMapper carMapper = CarMapper.INSTANCE;

    CarRepository carRepository = new CarRepositoryImpl();

    /**
     * Constructor for the CarServiceImpl class.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CarServiceImpl() throws SQLException {
    }

    /**
     * Retrieves a car DTO by its ID.
     *
     * @param carId The ID of the car.
     * @return The car DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarDto getCarByCarId(UUID carId) throws SQLException {
        return carMapper.carToCarDto(carRepository.getCarByCarId(carId));
    }

    /**
     * Retrieves a car DTO by its VIN (Vehicle Identification Number).
     *
     * @param vin The VIN of the car.
     * @return The car DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarDto getCarByVin(String vin) throws SQLException {
        return carMapper.carToCarDto(carRepository.getCarByVin(vin));
    }

    /**
     * Retrieves all car DTOs of a specific model.
     *
     * @param modelId The ID of the model.
     * @return A list of car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarDto> getCarByModelId(UUID modelId) throws SQLException {
        return carRepository.getCarByModelId(modelId).stream().map(carMapper::carToCarDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car DTOs.
     *
     * @return A list of all car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarDto> getAllCars() throws SQLException {
        return carRepository.getAllCars().stream().map(carMapper::carToCarDto).collect(Collectors.toList());
    }

    /**
     * Creates a new car record in the database with the provided VIN and model ID.
     *
     * @param vin     The VIN of the new car.
     * @param modelId The ID of the model of the new car.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String vin, UUID modelId) throws SQLException {
        carRepository.create(vin, modelId);
    }

    /**
     * Updates an existing car record in the database with a new VIN and model ID using its ID and the new VIN and model ID.
     *
     * @param carId   The ID of the car to update.
     * @param vin     The new VIN for the car record.
     * @param modelId The new model ID for the car record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID carId, String vin, UUID modelId) throws SQLException {
        carRepository.update(carId, vin, modelId);
    }

    /**
     * Deletes a specific car record from the database using its ID.
     *
     * @param carId The ID of the car to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID carId) throws SQLException {
        carRepository.delete(carId);
    }
}
