package mapper;

import dto.CarDto;
import entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The CarMapper interface provides methods for mapping between Car and CarDto objects.
 * This mapper also uses the LayoutMapper for mapping between Layout and LayoutDto objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(uses = LayoutMapper.class)
public interface CarMapper {

    /**
     * The singleton instance of the mapper.
     */
    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    /**
     * Maps a Car entity to a CarDto. Also maps the Layout entity to a LayoutDto.
     *
     * @param car the Car entity to be mapped.
     * @return the mapped CarDto.
     */
    @Mapping(source = "layout", target = "layout")
    CarDto carToCarDto(Car car);

    /**
     * Maps a CarDto to a Car entity.
     *
     * @param carDto the CarDto to be mapped.
     * @return the mapped Car entity.
     */
    Car carDtoToCar(CarDto carDto);
}
