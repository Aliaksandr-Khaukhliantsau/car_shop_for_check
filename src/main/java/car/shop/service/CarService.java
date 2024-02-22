package car.shop.service;

import car.shop.dto.CarDto;

import java.util.List;
import java.util.UUID;

public interface CarService {

    CarDto getById(UUID id);

    CarDto getByVin(String vin);

    List<CarDto> getByLayoutId(UUID layoutId);

    List<CarDto> getAll();

    void create(String vin, UUID layoutId);

    void update(UUID id, String vin, UUID layoutId);

    void delete(UUID id);
}
