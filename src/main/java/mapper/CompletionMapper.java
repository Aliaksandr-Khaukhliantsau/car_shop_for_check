package mapper;

import dto.CarOptionDto;
import dto.CompletionDto;
import entity.CarOption;
import entity.Completion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The CompletionMapper interface provides methods for mapping between Completion and CompletionDto objects.
 * It uses MapStruct, a code generator that simplifies the implementation of mappings between Java bean types.
 * This mapper also uses the CarOptionMapper for mapping between CarOption and CarOptionDto objects.
 */
@Mapper(uses = CarOptionMapper.class)
public interface CompletionMapper {

    /**
     * An instance of the CompletionMapper, created by the MapStruct library.
     */
    CompletionMapper INSTANCE = Mappers.getMapper(CompletionMapper.class);

    /**
     * Maps a Completion entity to a CompletionDto. Also maps the list of CarOption entities to a list of CarOptionDto objects.
     *
     * @param completion The Completion entity to be mapped.
     * @return The mapped CompletionDto.
     */
    @Mapping(source = "carOptions", target = "carOptions")
    CompletionDto completionToCompletionDto(Completion completion);

    /**
     * Maps a list of CarOption entities to a list of CarOptionDto objects.
     *
     * @param carOptions The list of CarOption entities to be mapped.
     * @return The mapped list of CarOptionDto objects.
     */
    List<CarOptionDto> map(List<CarOption> carOptions);

    /**
     * Maps a CompletionDto to a Completion entity.
     *
     * @param completionDTO The CompletionDto to be mapped.
     * @return The mapped Completion entity.
     */
    Completion completionDtoToCompletion(CompletionDto completionDTO);

    /**
     * Maps a list of CarOptionDto objects to a list of CarOption entities.
     *
     * @param carOptions The list of CarOptionDto objects to be mapped.
     * @return The mapped list of CarOption entities.
     */
    List<CarOption> mapDto(List<CarOptionDto> carOptions);
}
