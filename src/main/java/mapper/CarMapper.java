package mapper;

import dto.CarDto;
import entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The CarMapper interface provides methods for mapping between Car and CarDto objects.
 * It uses MapStruct, a code generator that simplifies the implementation of mappings between Java bean types.
 * This mapper also uses the CarModelMapper for mapping between CarModel and CarModelDto objects.
 */
@Mapper(uses = CarModelMapper.class)
public interface CarMapper {

    /**
     * An instance of the CarMapper, created by the MapStruct library.
     */
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    /**
     * Maps a Car entity to a CarDto. Also maps the CarModel entity to a CarModelDto.
     *
     * @param car The Car entity to be mapped.
     * @return The mapped CarDto.
     */
    @Mapping(source = "carModel", target = "carModel")
    CarDto carToCarDto(Car car);

    /**
     * Maps a CarDto to a Car entity.
     *
     * @param carDTO The CarDto to be mapped.
     * @return The mapped Car entity.
     */
    Car carDtoToCar(CarDto carDTO);
}
