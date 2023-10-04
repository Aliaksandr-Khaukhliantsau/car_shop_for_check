package entity;

import java.util.UUID;

// Во всех классах подключаешь ломбок.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Car {
    private UUID carId;
    private String vin;
    private CarModel carModel;

    public Car() {
    }

    public Car(UUID carId, String vin, CarModel carModel) {
        this.carId = carId;
        this.vin = vin;
        this.carModel = carModel;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", vin='" + vin + '\'' +
                ", carModel=" + carModel +
                '}';
    }
}
