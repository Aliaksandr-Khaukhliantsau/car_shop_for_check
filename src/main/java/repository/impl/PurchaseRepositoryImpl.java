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

/**
 * The PurchaseRepositoryImpl class implements the PurchaseRepository interface.
 * This class provides methods to interact with the purchases data in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class PurchaseRepositoryImpl implements PurchaseRepository {
    private static final String SQL_GET_BY_ID = "SELECT * FROM purchases WHERE id = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_BY_PURCHASE_NUMBER = "SELECT * FROM purchases WHERE purchase_number = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_BY_CUSTOMER_ID = "SELECT * FROM purchases WHERE customer_id = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_BY_CAR_ID = "SELECT * FROM purchases WHERE car_id = ? ORDER BY purchase_number ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM purchases ORDER BY purchase_number ASC;";
    private static final String SQL_CREATE = "INSERT INTO purchases (customer_id, car_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE purchases SET customer_id = ?, car_id = ? WHERE id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM purchases WHERE id = ? RETURNING *;";
    private static final CustomerMapper CUSTOMER_MAPPER = CustomerMapper.CUSTOMER_MAPPER;
    private static final CarMapper CAR_MAPPER = CarMapper.CAR_MAPPER;
    private static final int PARAMETER_INDEX_ONE = 1;
    private static final int PARAMETER_INDEX_TWO = 2;
    private static final int PARAMETER_INDEX_THREE = 3;
    private final Connection connection;

    {
        try {
            connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method retrieves a purchase by its ID.
     *
     * @param id the ID of the purchase to retrieve.
     * @return the purchase corresponding to the provided ID.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Purchase getById(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Purchase purchase = new Purchase();

            while (resultSet.next()) {
                purchase.setId(UUID.fromString(resultSet.getString("id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getById(customerId);
                purchase.setCustomer(CUSTOMER_MAPPER.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getById(carId);
                purchase.setCar(CAR_MAPPER.carDtoToCar(carDto));
            }
            return purchase;
        }
    }

    /**
     * This method retrieves a purchase by its purchase number.
     *
     * @param purchaseNumber the purchase number of the purchase to retrieve.
     * @return the purchase corresponding to the provided purchase number.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Purchase getByPurchaseNumber(String purchaseNumber) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_PURCHASE_NUMBER)) {
            preparedStatement.setInt(PARAMETER_INDEX_ONE, Integer.parseInt(purchaseNumber));
            ResultSet resultSet = preparedStatement.executeQuery();
            Purchase purchase = new Purchase();

            while (resultSet.next()) {
                purchase.setId(UUID.fromString(resultSet.getString("id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getById(customerId);
                purchase.setCustomer(CUSTOMER_MAPPER.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getById(carId);
                purchase.setCar(CAR_MAPPER.carDtoToCar(carDto));
            }
            return purchase;
        }
    }

    /**
     * This method retrieves all purchases made by a specific customer.
     *
     * @param customerId the ID of the customer whose purchases to retrieve.
     * @return a list of purchases made by the specified customer.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Purchase> getByCustomerId(UUID customerId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_CUSTOMER_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();

            while (resultSet.next()) {
                Purchase purchase = new Purchase();
                purchase.setId(UUID.fromString(resultSet.getString("id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getById(customerId);
                purchase.setCustomer(CUSTOMER_MAPPER.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getById(carId);
                purchase.setCar(CAR_MAPPER.carDtoToCar(carDto));

                purchases.add(purchase);
            }
            return purchases;
        }
    }

    /**
     * This method retrieves all purchases made for a specific car.
     *
     * @param carId the ID of the car whose purchases to retrieve.
     * @return a list of purchases made for the specified car.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Purchase> getByCarId(UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_CAR_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();

            while (resultSet.next()) {
                Purchase purchase = new Purchase();
                purchase.setId(UUID.fromString(resultSet.getString("id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                CustomerService customerService = new CustomerServiceImpl();
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerDto customerDto = customerService.getById(customerId);
                purchase.setCustomer(CUSTOMER_MAPPER.customerDtoToCustomer(customerDto));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getById(carId);
                purchase.setCar(CAR_MAPPER.carDtoToCar(carDto));

                purchases.add(purchase);
            }
            return purchases;
        }
    }

    /**
     * This method retrieves all purchases.
     *
     * @return a list of all purchases.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Purchase> getAll() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();

            while (resultSet.next()) {
                Purchase purchase = new Purchase();
                purchase.setId(UUID.fromString(resultSet.getString("id")));
                purchase.setPurchaseNumber(resultSet.getInt("purchase_number"));
                UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
                CustomerService customerService = new CustomerServiceImpl();
                CustomerDto customerDto = customerService.getById(customerId);
                purchase.setCustomer(CUSTOMER_MAPPER.customerDtoToCustomer(customerDto));
                UUID carId = UUID.fromString(resultSet.getString("car_id"));
                CarService carService = new CarServiceImpl();
                CarDto carDto = carService.getById(carId);
                purchase.setCar(CAR_MAPPER.carDtoToCar(carDto));

                purchases.add(purchase);
            }
            return purchases;
        }
    }

    /**
     * This method creates a new purchase.
     *
     * @param customerId the ID of the customer making the purchase.
     * @param carId      the ID of the car being purchased.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(UUID customerId, UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, customerId);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, carId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * This method updates an existing purchase.
     *
     * @param id         the ID of the purchase to update.
     * @param customerId the new customer ID for the purchase.
     * @param carId      the new car ID for the purchase.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, UUID customerId, UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, customerId);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, carId);
            preparedStatement.setObject(PARAMETER_INDEX_THREE, id);
            preparedStatement.executeQuery();
        }
    }

    /**
     * This method deletes a purchase.
     *
     * @param id the ID of the purchase to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            preparedStatement.executeQuery();
        }
    }
}
