package mapper;

import dto.CarOptionDto;
import entity.CarOption;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The CarOptionMapper interface provides methods for mapping between CarOption and CarOptionDto objects.
 * It uses MapStruct, a code generator that simplifies the implementation of mappings between Java bean types.
 */
@Mapper
public interface CarOptionMapper {

    /**
     * An instance of the CarOptionMapper, created by the MapStruct library.
     */
    CarOptionMapper INSTANCE = Mappers.getMapper(CarOptionMapper.class);

    /**
     * Maps a CarOption entity to a CarOptionDto.
     *
     * @param carOption The CarOption entity to be mapped.
     * @return The mapped CarOptionDto.
     */
    CarOptionDto carOptionToCarOptionDto(CarOption carOption);

    /**
     * Maps a CarOptionDto to a CarOption entity.
     *
     * @param carOptionDTO The CarOptionDto to be mapped.
     * @return The mapped CarOption entity.
     */
    CarOption carOptionDtoToCarOption(CarOptionDto carOptionDTO);
}
