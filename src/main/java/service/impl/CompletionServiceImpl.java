package service.impl;

import dto.CompletionDto;
import mapper.CompletionMapper;
import repository.CompletionRepository;
import repository.impl.CompletionRepositoryImpl;
import service.CompletionService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of the CompletionService interface.
 */
public class CompletionServiceImpl implements CompletionService {
    private static final CompletionMapper completionMapper = CompletionMapper.INSTANCE;

    CompletionRepository completionRepository = new CompletionRepositoryImpl();

    /**
     * Constructor for the CompletionServiceImpl class.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CompletionServiceImpl() throws SQLException {
    }

    /**
     * Retrieves a completion by its ID.
     *
     * @param completionId The ID of the completion.
     * @return The completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CompletionDto getCompletionByCompletionId(UUID completionId) throws SQLException {
        return completionMapper.completionToCompletionDto(completionRepository.getCompletionByCompletionId(completionId));
    }

    /**
     * Retrieves a completion by its name.
     *
     * @param completionName The name of the completion.
     * @return The completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CompletionDto getCompletionByCompletionName(String completionName) throws SQLException {
        return completionMapper.completionToCompletionDto(completionRepository.getCompletionByCompletionName(completionName));
    }

    /**
     * Retrieves all completions.
     *
     * @return A list of all completion DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CompletionDto> getAllCompletions() throws SQLException {
        return completionRepository.getAllCompletions().stream().map(completionMapper::completionToCompletionDto).collect(Collectors.toList());
    }

    /**
     * Adds a car option to a specific completion in the database.
     *
     * @param completionId The ID of the completion to add the car option to.
     * @param optionId     The ID of the car option to add.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void addCarOption(UUID completionId, UUID optionId) throws SQLException {
        completionRepository.addCarOption(completionId, optionId);
    }

    /**
     * Deletes a car option from a specific completion in the database using its ID and the ID of the car option.
     *
     * @param completionId The ID of the completion to delete the car option from.
     * @param optionId     The ID of the car option to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void deleteCarOption(UUID completionId, UUID optionId) throws SQLException {
        completionRepository.deleteCarOption(completionId, optionId);
    }

    /**
     * Creates a new completion record in the database with the provided name.
     *
     * @param completionName The name of the new completion.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String completionName) throws SQLException {
        completionRepository.create(completionName);
    }

    /**
     * Updates an existing completion record in the database with a new name using its ID and the new name.
     *
     * @param CompletionId   The ID of the completion to update.
     * @param completionName The new name for the completion record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID CompletionId, String completionName) throws SQLException {
        completionRepository.update(CompletionId, completionName);
    }

    /**
     * Deletes a specific completion record from the database using its ID.
     *
     * @param CompletionId The ID of the completion to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID CompletionId) throws SQLException {
        completionRepository.delete(CompletionId);
    }
}
