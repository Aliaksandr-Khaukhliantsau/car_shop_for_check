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

/**
 * Implementation of the CarOptionService interface.
 */
public class CarOptionServiceImpl implements CarOptionService {
    private static final CarOptionMapper carOptionMapper = CarOptionMapper.INSTANCE;

    CarOptionRepository carOptionRepository = new CarOptionRepositoryImpl();

    /**
     * Constructor for the CarOptionServiceImpl class.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CarOptionServiceImpl() throws SQLException {
    }

    /**
     * Retrieves a car option by its ID.
     *
     * @param optionId The ID of the car option.
     * @return The car option DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarOptionDto getCarOptionByOptionId(UUID optionId) throws SQLException {
        return carOptionMapper.carOptionToCarOptionDto(carOptionRepository.getCarOptionByOptionId(optionId));

    }

    /**
     * Retrieves a car option by its name.
     *
     * @param optionName The name of the car option.
     * @return The car option DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarOptionDto getCarOptionByOptionName(String optionName) throws SQLException {
        return carOptionMapper.carOptionToCarOptionDto(carOptionRepository.getCarOptionByOptionName(optionName));
    }

    /**
     * Retrieves all car options for a specific completion.
     *
     * @param completionId The ID of the completion.
     * @return A list of car option DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarOptionDto> getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        return carOptionRepository.getCarOptionsByCompletionId(completionId).stream().map(carOptionMapper::carOptionToCarOptionDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car options.
     *
     * @return A list of all car option DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarOptionDto> getAllCarOptions() throws SQLException {
        return carOptionRepository.getAllCarOptions().stream().map(carOptionMapper::carOptionToCarOptionDto).collect(Collectors.toList());
    }

    /**
     * Creates a new car option record in the database with the provided name.
     *
     * @param optionName The name of the new car option.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String optionName) throws SQLException {
        carOptionRepository.create(optionName);
    }

    /**
     * Updates an existing car option record in the database with a new name using its ID and the new name.
     *
     * @param optionId   The ID of the car option to update.
     * @param optionName The new name for the car option record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID optionId, String optionName) throws SQLException {
        carOptionRepository.update(optionId, optionName);
    }

    /**
     * Deletes a specific car option record from the database using its ID.
     *
     * @param optionId The ID of the car option to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID optionId) throws SQLException {
        carOptionRepository.delete(optionId);
    }
}
