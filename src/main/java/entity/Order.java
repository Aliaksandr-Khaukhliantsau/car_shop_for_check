package entity;

public class Order {
    private String OrderId;
    private int OrderNumber;
    private Customer customer;
    private Car car;

    public Order() {
    }


    public Order(String OrderId, int OrderNumber, Customer customer, Car car) {
        this.OrderId = OrderId;
        this.OrderNumber = OrderNumber;
        this.customer = customer;
        this.car = car;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        this.OrderId = orderId;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.OrderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderId='" + OrderId + '\'' +
                ", OrderNumber=" + OrderNumber +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }
}
