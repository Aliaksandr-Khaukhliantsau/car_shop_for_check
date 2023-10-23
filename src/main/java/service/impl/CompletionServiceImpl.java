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
 * This class provides methods to interact with completion data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CompletionServiceImpl implements CompletionService {
    private static final CompletionMapper COMPLETION_MAPPER = CompletionMapper.COMPLETION_MAPPER;
    CompletionRepository completionRepository = new CompletionRepositoryImpl();

    /**
     * Retrieves a completion DTO by its ID.
     *
     * @param id the ID of the completion.
     * @return the completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CompletionDto getById(UUID id) throws SQLException {
        return COMPLETION_MAPPER.completionToCompletionDto(completionRepository.getById(id));
    }

    /**
     * Retrieves a completion DTO by its name.
     *
     * @param completionName the name of the completion.
     * @return the completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CompletionDto getByCompletionName(String completionName) throws SQLException {
        return COMPLETION_MAPPER.completionToCompletionDto(completionRepository.getByCompletionName(completionName));
    }

    /**
     * Retrieves all completion DTOs.
     *
     * @return a list of all completion DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CompletionDto> getAll() throws SQLException {
        return completionRepository.getAll().stream().map(COMPLETION_MAPPER::completionToCompletionDto).collect(Collectors.toList());
    }

    /**
     * Adds a car setting to a specific completion in the database.
     *
     * @param id        the ID of the completion to add the car setting to.
     * @param settingId the ID of the car setting to add.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void addSetting(UUID id, UUID settingId) throws SQLException {
        completionRepository.addSetting(id, settingId);
    }

    /**
     * Deletes a car setting from a specific completion in the database using its ID and the ID of the car setting.
     *
     * @param id        the ID of the completion to delete the car setting from.
     * @param settingId the ID of the car setting to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void deleteSetting(UUID id, UUID settingId) throws SQLException {
        completionRepository.deleteSetting(id, settingId);
    }

    /**
     * Creates a new completion record in the database with the provided name.
     *
     * @param completionName the name of the new completion.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String completionName) throws SQLException {
        completionRepository.create(completionName);
    }

    /**
     * Updates an existing completion record in the database with a new name using its ID and the new name.
     *
     * @param id             the ID of the completion to update.
     * @param completionName the new name for the completion record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String completionName) throws SQLException {
        completionRepository.update(id, completionName);
    }

    /**
     * Deletes a specific completion record from the database using its ID.
     *
     * @param id the ID of the completion to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        completionRepository.delete(id);
    }
}
