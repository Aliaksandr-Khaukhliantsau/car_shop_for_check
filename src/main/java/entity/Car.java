package entity;

import java.util.UUID;

// Во всех классах подключаешь ломбок.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Car {
    private UUID carId;
    private String vin;
    private Model model;

    public Car() {
    }

    public Car(UUID carId, String vin, Model model) {
        this.carId = carId;
        this.vin = vin;
        this.model = model;
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", vin='" + vin + '\'' +
                ", model=" + model +
                '}';
    }
}
