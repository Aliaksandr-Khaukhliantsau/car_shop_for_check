package car.shop.mapper;

import car.shop.dto.CarDto;
import car.shop.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LayoutMapper.class)
public interface CarMapper {

    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDto);
}