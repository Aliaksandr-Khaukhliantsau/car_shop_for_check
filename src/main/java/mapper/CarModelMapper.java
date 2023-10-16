package mapper;

import dto.CarModelDto;
import entity.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The CarModelMapper interface provides methods for mapping between CarModel and CarModelDto objects.
 * This mapper also uses the CompletionMapper for mapping between Completion and CompletionDto objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(uses = CompletionMapper.class)
public interface CarModelMapper {

    /**
     * The singleton instance of the mapper.
     */
    CarModelMapper INSTANCE = Mappers.getMapper(CarModelMapper.class);

    /**
     * Maps a CarModel entity to a CarModelDto. Also maps the Completion entity to a CompletionDto.
     *
     * @param carModel the CarModel entity to be mapped.
     * @return the mapped CarModelDto.
     */
    @Mapping(source = "completion", target = "completion")
    CarModelDto carModelToCarModelDto(CarModel carModel);

    /**
     * Maps a CarModelDto to a CarModel entity.
     *
     * @param carModelDTO the CarModelDto to be mapped.
     * @return the mapped CarModel entity.
     */
    CarModel carModelDtoToCarModel(CarModelDto carModelDTO);
}
