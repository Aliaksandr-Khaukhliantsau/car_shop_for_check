package service.impl;

import entity.Car;
import entity.Customer;
import entity.Purchase;
import repository.PurchaseRepository;
import repository.impl.PurchaseRepositoryImpl;
import service.CarService;
import service.CustomerService;
import service.PurchaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PurchaseServiceImpl implements PurchaseService {
    PurchaseRepository purchaseRepository = new PurchaseRepositoryImpl();

    public PurchaseServiceImpl() throws SQLException {
    }

    @Override
    public List<Purchase> getPurchaseByPurchaseId(UUID orderId) throws SQLException {
        ResultSet resultSet = purchaseRepository.getPurchaseByPurchaseId(orderId);
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> getPurchaseByPurchaseNumber(String orderNumber) throws SQLException {
        ResultSet resultSet = purchaseRepository.getPurchaseByPurchaseNumber(orderNumber);
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> getPurchaseByCustomerId(UUID customerId) throws SQLException {
        ResultSet resultSet = purchaseRepository.getPurchaseByCustomerId(customerId);
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> getPurchaseByCarId(UUID carId) throws SQLException {
        ResultSet resultSet = purchaseRepository.getPurchaseByCarId(carId);
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> getPurchaseByCustomer(Customer customer) throws SQLException {
        ResultSet resultSet = purchaseRepository.getPurchaseByCustomerId(customer.getCustomerId());
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> getPurchaseByCar(Car car) throws SQLException {
        ResultSet resultSet = purchaseRepository.getPurchaseByCarId(car.getCarId());
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> getAllPurchases() throws SQLException {
        ResultSet resultSet = purchaseRepository.getAllPurchases();
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> create(UUID customerId, UUID carId) throws SQLException {
        ResultSet resultSet = purchaseRepository.create(customerId, carId);
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException {
        ResultSet resultSet = purchaseRepository.update(purchaseId, customerId, carId);
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    @Override
    public List<Purchase> delete(UUID purchaseId) throws SQLException {
        ResultSet resultSet = purchaseRepository.delete(purchaseId);
        List<Purchase> purchaseList = new ArrayList<>();

        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(UUID.fromString(resultSet.getString("id")));
            purchase.setPurchaseNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            purchase.setCustomer(customerService.getCustomerByCustomerId(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            purchase.setCar(carService.getCarByCarId(carId));

            purchaseList.add(purchase);
        }
        return purchaseList;
    }
}
