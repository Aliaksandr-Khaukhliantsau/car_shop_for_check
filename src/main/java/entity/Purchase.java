package entity;

import java.util.UUID;

public class Purchase {
    private UUID purchaseId;
    private int purchaseNumber;
    private Customer customer;
    private Car car;

    public Purchase() {
    }

    public Purchase(UUID purchaseId, int purchaseNumber, Customer customer, Car car) {
        this.purchaseId = purchaseId;
        this.purchaseNumber = purchaseNumber;
        this.customer = customer;
        this.car = car;
    }

    public UUID getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(UUID purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
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
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", purchaseNumber=" + purchaseNumber +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }
}
