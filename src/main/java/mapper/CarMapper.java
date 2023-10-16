package mapper;

import dto.CarDto;
import entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The CarMapper interface provides methods for mapping between Car and CarDto objects.
 * This mapper also uses the CarModelMapper for mapping between CarModel and CarModelDto objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(uses = CarModelMapper.class)
public interface CarMapper {

    /**
     * The singleton instance of the mapper.
     */
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    /**
     * Maps a Car entity to a CarDto. Also maps the CarModel entity to a CarModelDto.
     *
     * @param car the Car entity to be mapped.
     * @return the mapped CarDto.
     */
    @Mapping(source = "carModel", target = "carModel")
    CarDto carToCarDto(Car car);

    /**
     * Maps a CarDto to a Car entity.
     *
     * @param carDTO the CarDto to be mapped.
     * @return the mapped Car entity.
     */
    Car carDtoToCar(CarDto carDTO);
}
