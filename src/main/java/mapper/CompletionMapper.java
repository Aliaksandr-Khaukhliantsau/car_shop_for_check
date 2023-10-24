package mapper;

import dto.CompletionDto;
import dto.SettingDto;
import entity.Completion;
import entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The CompletionMapper interface provides methods for mapping between Completion and CompletionDto objects.
 * This mapper also uses the SettingMapper for mapping between Setting and SettingDto objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(uses = SettingMapper.class)
public interface CompletionMapper {

    /**
     * The singleton instance of the mapper.
     */
    CompletionMapper COMPLETION_MAPPER = Mappers.getMapper(CompletionMapper.class);

    /**
     * Maps a Completion entity to a CompletionDto. Also maps the list of Setting entities to a list of SettingDto objects.
     *
     * @param completion the Completion entity to be mapped.
     * @return the mapped CompletionDto.
     */
    @Mapping(source = "settings", target = "settings")
    CompletionDto completionToCompletionDto(Completion completion);

    /**
     * Maps a list of Setting entities to a list of SettingDto objects.
     *
     * @param settings the list of Setting entities to be mapped.
     * @return the mapped list of SettingDto objects.
     */
    List<SettingDto> map(List<Setting> settings);

    /**
     * Maps a CompletionDto to a Completion entity.
     *
     * @param completionDto the CompletionDto to be mapped.
     * @return the mapped Completion entity.
     */
    Completion completionDtoToCompletion(CompletionDto completionDto);

    /**
     * Maps a list of SettingDto objects to a list of Setting entities.
     *
     * @param settings the list of SettingDto objects to be mapped.
     * @return the mapped list of Setting entities.
     */
    List<Setting> mapDto(List<SettingDto> settings);
}
