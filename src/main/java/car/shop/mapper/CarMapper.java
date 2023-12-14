package car.shop.mapper;

import car.shop.dto.CarDto;
import car.shop.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = LayoutMapper.class)
public interface CarMapper {

    @Mapping(target = "purchase", ignore = true)
    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDto);
}