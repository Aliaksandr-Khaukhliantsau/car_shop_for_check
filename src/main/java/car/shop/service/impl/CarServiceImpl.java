package car.shop.service.impl;

import car.shop.dto.CarDto;
import car.shop.entity.Car;
import car.shop.entity.Layout;
import car.shop.mapper.CarMapper;
import car.shop.repository.CarRepository;
import car.shop.repository.LayoutRepository;
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
    private final LayoutRepository layoutRepository;
    private final CarMapper carMapper;


    @Override
    @Transactional
    public CarDto getById(UUID id) {
        Car car = carRepository.findById(id).orElse(null);
        return carMapper.carToCarDto(car);
    }

    @Override
    @Transactional
    public CarDto getByVin(String vin) {
        Car car = carRepository.findByVin(vin).orElse(null);
        return carMapper.carToCarDto(car);
    }

    @Override
    @Transactional
    public List<CarDto> getByLayoutId(UUID layoutId) {
        return carRepository.findByLayoutId(layoutId).stream().map(carMapper::carToCarDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CarDto> getAll() {
        return carRepository.findAll().stream().map(carMapper::carToCarDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(String vin, UUID layoutId) {
        Layout layout = layoutRepository.findById(layoutId).orElse(null);
        if (layout != null) {
            Car car = new Car();
            car.setVin(vin);
            car.setLayoutId(layoutId);
            carRepository.save(car);
        }
    }

    @Override
    @Transactional
    public void update(UUID id, String vin, UUID layoutId) {
        Car car = carRepository.findById(id).orElse(null);
        Layout layout = layoutRepository.findById(layoutId).orElse(null);
        if (car != null && layout != null) {
            car.setVin(vin);
            car.setLayoutId(layoutId);
            carRepository.save(car);
        }
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        carRepository.deleteById(id);
    }
}
