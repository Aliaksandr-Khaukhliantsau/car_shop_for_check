package car.shop.service;

import car.shop.dto.CarDto;
import car.shop.entity.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {

    CarDto getById(UUID id);

    CarDto getByVin(String vin);

    List<CarDto> getAll();

    void create(Car car);

    void update(Car car);

    void delete(UUID id);
}
