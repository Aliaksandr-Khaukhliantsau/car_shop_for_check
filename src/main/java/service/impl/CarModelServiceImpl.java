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

/**
 * Implementation of the CarModelService interface.
 * This class provides methods to interact with car model data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CarModelServiceImpl implements CarModelService {
    private static final CarModelMapper carModelMapper = mapper.CarModelMapper.INSTANCE;

    CarModelRepository carModelRepository = new CarModelRepositoryImpl();

    /**
     * Constructor for the CarModelServiceImpl class.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CarModelServiceImpl() throws SQLException {
    }

    /**
     * Retrieves a car model DTO by its ID.
     *
     * @param modelId The ID of the car model.
     * @return The car model DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarModelDto getCarModelByModelId(UUID modelId) throws SQLException {
        return carModelMapper.carModelToCarModelDto(carModelRepository.getCarModelByModelId(modelId));
    }

    /**
     * Retrieves all car model DTOs with a specific name.
     *
     * @param modelName The name of the car models.
     * @return A list of car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarModelDto> getCarModelByModelName(String modelName) throws SQLException {
        return carModelRepository.getCarModelByModelName(modelName).stream().map(carModelMapper::carModelToCarModelDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car model DTOs for a specific completion.
     *
     * @param completionId The ID of the completion.
     * @return A list of car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarModelDto> getCarModelByCompletionId(UUID completionId) throws SQLException {
        return carModelRepository.getCarModelByCompletionId(completionId).stream().map(carModelMapper::carModelToCarModelDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car model DTOs.
     *
     * @return A list of all car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarModelDto> getAllCarModels() throws SQLException {
        return carModelRepository.getAllCarModels().stream().map(carModelMapper::carModelToCarModelDto).collect(Collectors.toList());
    }

    /**
     * Creates a new car model record in the database with the provided name and completion ID.
     *
     * @param modelName    The name of the new car model.
     * @param completionId The ID of the completion of the new car model.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String modelName, UUID completionId) throws SQLException {
        carModelRepository.create(modelName, completionId);
    }

    /**
     * Updates an existing car model record in the database with a new name and completion ID using its ID and the new name and completion ID.
     *
     * @param modelId      The ID of the car model to update.
     * @param modelName    The new name for the car model record.
     * @param completionId The new completion ID for the car model record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        carModelRepository.update(modelId, modelName, completionId);
    }

    /**
     * Deletes a specific car model record from the database using its ID.
     *
     * @param modelId The ID of the car model to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID modelId) throws SQLException {
        carModelRepository.delete(modelId);
    }
}
