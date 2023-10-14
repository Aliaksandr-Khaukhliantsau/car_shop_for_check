package mapper;

import dto.CarModelDto;
import entity.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The CarModelMapper interface provides methods for mapping between CarModel and CarModelDto objects.
 * It uses MapStruct, a code generator that simplifies the implementation of mappings between Java bean types.
 * This mapper also uses the CompletionMapper for mapping between Completion and CompletionDto objects.
 */
@Mapper(uses = CompletionMapper.class)
public interface CarModelMapper {

    /**
     * An instance of the CarModelMapper, created by the MapStruct library.
     */
    CarModelMapper INSTANCE = Mappers.getMapper(CarModelMapper.class);

    /**
     * Maps a CarModel entity to a CarModelDto. Also maps the Completion entity to a CompletionDto.
     *
     * @param carModel The CarModel entity to be mapped.
     * @return The mapped CarModelDto.
     */
    @Mapping(source = "completion", target = "completion")
    CarModelDto carModelToCarModelDto(CarModel carModel);

    /**
     * Maps a CarModelDto to a CarModel entity.
     *
     * @param carModelDTO The CarModelDto to be mapped.
     * @return The mapped CarModel entity.
     */
    CarModel carModelDtoToCarModel(CarModelDto carModelDTO);
}
