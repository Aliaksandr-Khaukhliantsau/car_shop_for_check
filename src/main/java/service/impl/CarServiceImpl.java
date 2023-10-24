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
    private static final CarMapper CAR_MAPPER = CarMapper.CAR_MAPPER;
    CarRepository carRepository = new CarRepositoryImpl();

    /**
     * Retrieves a car DTO by its ID.
     *
     * @param id the ID of the car.
     * @return the car DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarDto getById(UUID id) throws SQLException {
        return CAR_MAPPER.carToCarDto(carRepository.getById(id));
    }

    /**
     * Retrieves a car DTO by its VIN (vehicle identification number).
     *
     * @param vin the VIN of the car.
     * @return the car DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarDto getByVin(String vin) throws SQLException {
        return CAR_MAPPER.carToCarDto(carRepository.getByVin(vin));
    }

    /**
     * Retrieves all car DTOs of a specific layout.
     *
     * @param layoutId the ID of the layout.
     * @return a list of car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarDto> getByLayoutId(UUID layoutId) throws SQLException {
        return carRepository.getByLayoutId(layoutId).stream().map(CAR_MAPPER::carToCarDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car DTOs.
     *
     * @return a list of all car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarDto> getAll() throws SQLException {
        return carRepository.getAll().stream().map(CAR_MAPPER::carToCarDto).collect(Collectors.toList());
    }

    /**
     * Creates a new car record in the database with the provided VIN and layout ID.
     *
     * @param vin      the VIN of the new car.
     * @param layoutId the ID of the layout of the new car.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String vin, UUID layoutId) throws SQLException {
        carRepository.create(vin, layoutId);
    }

    /**
     * Updates an existing car record in the database with a new VIN and layout ID using its ID and the new VIN and layout ID.
     *
     * @param id       the ID of the car to update.
     * @param vin      the new VIN for the car record.
     * @param layoutId the new layout ID for the car record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String vin, UUID layoutId) throws SQLException {
        carRepository.update(id, vin, layoutId);
    }

    /**
     * Deletes a specific car record from the database using its ID.
     *
     * @param id the ID of the car to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        carRepository.delete(id);
    }
}
