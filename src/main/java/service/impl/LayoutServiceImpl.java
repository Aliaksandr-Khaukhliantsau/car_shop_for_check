package service.impl;

import dto.LayoutDto;
import mapper.LayoutMapper;
import repository.LayoutRepository;
import repository.impl.LayoutRepositoryImpl;
import service.LayoutService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of the LayoutService interface.
 * This class provides methods to interact with car layout data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class LayoutServiceImpl implements LayoutService {
    private static final LayoutMapper LAYOUT_MAPPER = LayoutMapper.LAYOUT_MAPPER;
    LayoutRepository layoutRepository = new LayoutRepositoryImpl();

    /**
     * Retrieves a car layout DTO by its ID.
     *
     * @param id the ID of the car layout.
     * @return the car layout DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public LayoutDto getById(UUID id) throws SQLException {
        return LAYOUT_MAPPER.layoutToLayoutDto(layoutRepository.getById(id));
    }

    /**
     * Retrieves all car layout DTOs with a specific name.
     *
     * @param layoutName the name of the car layouts.
     * @return a list of car layout DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<LayoutDto> getByLayoutName(String layoutName) throws SQLException {
        return layoutRepository.getByLayoutName(layoutName).stream().map(LAYOUT_MAPPER::layoutToLayoutDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car layout DTOs for a specific completion.
     *
     * @param completionId the ID of the completion.
     * @return a list of car layout DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<LayoutDto> getByCompletionId(UUID completionId) throws SQLException {
        return layoutRepository.getByCompletionId(completionId).stream().map(LAYOUT_MAPPER::layoutToLayoutDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all car layout DTOs.
     *
     * @return a list of all car layout DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<LayoutDto> getAll() throws SQLException {
        return layoutRepository.getAll().stream().map(LAYOUT_MAPPER::layoutToLayoutDto).collect(Collectors.toList());
    }

    /**
     * Creates a new car layout record in the database with the provided name and completion ID.
     *
     * @param layoutName   the name of the new car layout.
     * @param completionId the ID of the completion of the new car layout.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String layoutName, UUID completionId) throws SQLException {
        layoutRepository.create(layoutName, completionId);
    }

    /**
     * Updates an existing car layout record in the database with a new name and completion ID using its ID and the new name and completion ID.
     *
     * @param id           the ID of the car layout to update.
     * @param layoutName   the new name for the car layout record.
     * @param completionId the new completion ID for the car layout record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String layoutName, UUID completionId) throws SQLException {
        layoutRepository.update(id, layoutName, completionId);
    }

    /**
     * Deletes a specific car layout record from the database using its ID.
     *
     * @param id the ID of the car layout to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        layoutRepository.delete(id);
    }
}
