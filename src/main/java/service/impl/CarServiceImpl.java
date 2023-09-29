package service.impl;

import entity.Car;
import repository.CarRepository;
import repository.impl.CarRepositoryImpl;
import service.CarService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    CarRepository carRepository = new CarRepositoryImpl();

    public CarServiceImpl() throws SQLException {
    }

    @Override
    public List<Car> getById(String id) throws SQLException {
        ResultSet resultSet = carRepository.getById(id);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getString("id"));
            car.setVin(resultSet.getString("vin"));
            car.setIdModel(resultSet.getString("idmodel"));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> getByVin(String vin) throws SQLException {
        ResultSet resultSet = carRepository.getByVin(vin);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getString("id"));
            car.setVin(resultSet.getString("vin"));
            car.setIdModel(resultSet.getString("idmodel"));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> getByIdModel(String idModel) throws SQLException {
        ResultSet resultSet = carRepository.getByIdModel(idModel);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getString("id"));
            car.setVin(resultSet.getString("vin"));
            car.setIdModel(resultSet.getString("idmodel"));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        ResultSet resultSet = carRepository.getAllCars();
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getString("id"));
            car.setVin(resultSet.getString("vin"));
            car.setIdModel(resultSet.getString("idmodel"));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> create(String vin, String idModel) throws SQLException {
        ResultSet resultSet = carRepository.create(vin, idModel);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getString("id"));
            car.setVin(resultSet.getString("vin"));
            car.setIdModel(resultSet.getString("idmodel"));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> update(String id, String vin, String idModel) throws SQLException {
        ResultSet resultSet = carRepository.update(id, vin, idModel);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getString("id"));
            car.setVin(resultSet.getString("vin"));
            car.setIdModel(resultSet.getString("idmodel"));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> delete(String id) throws SQLException {
        ResultSet resultSet = carRepository.delete(id);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getString("id"));
            car.setVin(resultSet.getString("vin"));
            car.setIdModel(resultSet.getString("idmodel"));

            carList.add(car);
        }
        return carList;
    }
}
