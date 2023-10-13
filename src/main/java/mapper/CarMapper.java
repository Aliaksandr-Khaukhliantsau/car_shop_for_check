package mapper;

import dto.CarDto;
import entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CarModelMapper.class)
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "carModel", target = "carModel")
    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDTO);
}
