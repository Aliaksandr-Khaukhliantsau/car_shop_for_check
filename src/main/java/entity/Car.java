package entity;

public class Car {
    private String id;
    private String vin;
    private String idModel;

    public Car() {
    }

    public Car(String id, String vin, String idModel) {
        this.id = id;
        this.vin = vin;
        this.idModel = idModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", idModel='" + idModel + '\'' +
                '}';
    }
}
