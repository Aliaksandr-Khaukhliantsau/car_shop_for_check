package repository.impl;

import dto.CarDto;
import dto.CustomerDto;
import entity.Purchase;
import mapper.CarMapper;
import mapper.CustomerMapper;
import repository.PurchaseRepository;
import service.CarService;
import service.CustomerService;
import service.impl.CarServiceImpl;
import service.impl.CustomerServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PurchaseRepositoryImpl implements PurchaseRepository {
    private static final String SQL_GET_PURCHASE_BY_PURCHASE_ID = "SELECT * FROM purchases WHERE purchase_id = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_PURCHASE_BY_PURCHASE_NUMBER = "SELECT * FROM purchases WHERE purchase_number = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_PURCHASE_BY_CUSTOMER_ID = "SELECT * FROM purchases WHERE customer_id = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_PURCHASE_BY_CAR_ID = "SELECT * FROM purchases WHERE car_id = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_ALL_PURCHASES = "SELECT * FROM purchases ORDER BY purchase_number ASC;";
    private static final String SQL_CREATE_A_PURCHASE = "INSERT INTO purchases (customer_id, car_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_PURCHASE = "UPDATE purchases SET customer_id = ?, car_id = ? WHERE purchase_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_PURCHASE = "DELETE FROM purchases WHERE purchase_id = ? RETURNING *;";
    private static final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private static final CarMapper carMapper = CarMapper.INSTANCE;
    private final Connection connection;

    public PurchaseRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public Purchase getPurchaseByPurchaseId(UUID purchaseId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_PURCHASE_ID)) {
            preparedStatement.setObject(1, purchaseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Purchase purchase = new Purchase();

            while (resultSet.next()) {
                purchase.setPurchaseId(UUID.fromString(resultSet.getString("purchase_id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getCustomerByCustomerId(customerId);
                purchase.setCustomer(customerMapper.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getCarByCarId(carId);
                purchase.setCar(carMapper.carDtoToCar(carDto));
            }
            return purchase;
        }
    }

    @Override
    public Purchase getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_PURCHASE_NUMBER)) {
            preparedStatement.setInt(1, Integer.parseInt(purchaseNumber));
            ResultSet resultSet = preparedStatement.executeQuery();
            Purchase purchase = new Purchase();

            while (resultSet.next()) {
                purchase.setPurchaseId(UUID.fromString(resultSet.getString("purchase_id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getCustomerByCustomerId(customerId);
                purchase.setCustomer(customerMapper.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getCarByCarId(carId);
                purchase.setCar(carMapper.carDtoToCar(carDto));
            }
            return purchase;
        }
    }

    @Override
    public List<Purchase> getPurchaseByCustomerId(UUID customerId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_CUSTOMER_ID)) {
            preparedStatement.setObject(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();

            while (resultSet.next()) {
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(UUID.fromString(resultSet.getString("purchase_id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getCustomerByCustomerId(customerId);
                purchase.setCustomer(customerMapper.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getCarByCarId(carId);
                purchase.setCar(carMapper.carDtoToCar(carDto));

                purchases.add(purchase);
            }
            return purchases;
        }
    }

    @Override
    public List<Purchase> getPurchaseByCarId(UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_CAR_ID)) {
            preparedStatement.setObject(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();

            while (resultSet.next()) {
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(UUID.fromString(resultSet.getString("purchase_id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                CustomerService customerService = new CustomerServiceImpl();
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerDto customerDto = customerService.getCustomerByCustomerId(customerId);
                purchase.setCustomer(customerMapper.customerDtoToCustomer(customerDto));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getCarByCarId(carId);
                purchase.setCar(carMapper.carDtoToCar(carDto));

                purchases.add(purchase);
            }
            return purchases;
        }
    }

    @Override
    public List<Purchase> getAllPurchases() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_PURCHASES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();

            while (resultSet.next()) {
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(UUID.fromString(resultSet.getString("purchase_id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getCustomerByCustomerId(customerId);
                purchase.setCustomer(customerMapper.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getCarByCarId(carId);
                purchase.setCar(carMapper.carDtoToCar(carDto));

                purchases.add(purchase);
            }
            return purchases;
        }
    }

    @Override
    public void create(UUID customerId, UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_PURCHASE)) {
            preparedStatement.setObject(1, customerId);
            preparedStatement.setObject(2, carId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_PURCHASE)) {
            preparedStatement.setObject(1, customerId);
            preparedStatement.setObject(2, carId);
            preparedStatement.setObject(3, purchaseId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void delete(UUID purchaseId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_PURCHASE)) {
            preparedStatement.setObject(1, purchaseId);
            preparedStatement.executeQuery();
        }
    }
}
