package entity;

import java.util.UUID;

public class Order {
    private UUID orderId;
    private int orderNumber;
    private Customer customer;
    private Car car;

    public Order() {
    }

    public Order(UUID orderId, int orderNumber, Customer customer, Car car) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.car = car;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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
                "orderId=" + orderId +
                ", orderNumber=" + orderNumber +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }
}
