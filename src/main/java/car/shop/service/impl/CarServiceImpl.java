package car.shop.service.impl;

import car.shop.dto.CarDto;
import car.shop.entity.Car;
import car.shop.mapper.CarMapper;
import car.shop.repository.CarRepository;
import car.shop.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    @Transactional
    public CarDto getById(UUID id) {
        return carMapper.carToCarDto(carRepository.getById(id));
    }

    @Override
    @Transactional
    public CarDto getByVin(String vin) {
        return carMapper.carToCarDto(carRepository.getByVin(vin));
    }

    @Override
    @Transactional
    public List<CarDto> getAll() {
        return carRepository.findAll().stream()
                .map(carMapper::carToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(Car car) {
        carRepository.save(car);
    }

    @Override
    @Transactional
    public void update(Car car) {
        carRepository.save(car);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        carRepository.deleteById(id);
    }
}
