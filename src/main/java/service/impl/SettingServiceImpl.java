package service.impl;

import dto.SettingDto;
import mapper.SettingMapper;
import repository.SettingRepository;
import repository.impl.SettingRepositoryImpl;
import service.SettingService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of the SettingService interface.
 * This class provides methods to interact with car setting data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class SettingServiceImpl implements SettingService {
    private static final SettingMapper MODIFICATION_MAPPER = SettingMapper.INSTANCE;

    SettingRepository settingRepository = new SettingRepositoryImpl();

    /**
     * Constructor for the SettingServiceImpl class.
     *
     * @throws SQLException if a database access error occurs.
     */
    public SettingServiceImpl() throws SQLException {
    }

    /**
     * Retrieves a car setting DTO by its ID.
     *
     * @param id the ID of the car setting.
     * @return the car setting DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public SettingDto getById(UUID id) throws SQLException {
        return MODIFICATION_MAPPER.settingToSettingDto(settingRepository.getById(id));

    }

    /**
     * Retrieves a car setting DTO by its name.
     *
     * @param settingName the name of the car setting.
     * @return the car setting DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public SettingDto getBySettingName(String settingName) throws SQLException {
        return MODIFICATION_MAPPER.settingToSettingDto(settingRepository.getBySettingName(settingName));
    }

    /**
     * Retrieves all car setting DTOs for a specific completion.
     *
     * @param completionId the ID of the completion.
     * @return a list of car setting DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<SettingDto> getByCompletionId(UUID completionId) throws SQLException {
        return settingRepository.getByCompletionId(completionId).stream().map(MODIFICATION_MAPPER::settingToSettingDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car setting DTOs.
     *
     * @return a list of all car setting DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<SettingDto> getAll() throws SQLException {
        return settingRepository.getAll().stream().map(MODIFICATION_MAPPER::settingToSettingDto).collect(Collectors.toList());
    }

    /**
     * Creates a new car setting record in the database with the provided name.
     *
     * @param settingName the name of the new car setting.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String settingName) throws SQLException {
        settingRepository.create(settingName);
    }

    /**
     * Updates an existing car setting record in the database with a new name using its ID and the new name.
     *
     * @param id          the ID of the car setting to update.
     * @param settingName the new name for the car setting record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String settingName) throws SQLException {
        settingRepository.update(id, settingName);
    }

    /**
     * Deletes a specific car setting record from the database using its ID.
     *
     * @param id the ID of the car setting to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        settingRepository.delete(id);
    }
}
