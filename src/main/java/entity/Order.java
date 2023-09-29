package entity;

public class Order {
    private String id;
    private int number;
    private Customer customer;
    private String idCar;

    public Order() {
    }

    public Order(String id, int number, Customer customer, String idCar) {
        this.id = id;
        this.number = number;
        this.customer = customer;
        this.idCar = idCar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", customer=" + customer +
                ", idCar='" + idCar + '\'' +
                '}';
    }
}
