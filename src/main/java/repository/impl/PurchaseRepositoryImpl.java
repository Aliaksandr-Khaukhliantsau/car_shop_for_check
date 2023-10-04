package repository.impl;

import repository.PurchaseRepository;

import java.sql.*;
import java.util.UUID;

public class PurchaseRepositoryImpl implements PurchaseRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_ORDERS = "SELECT * FROM orders ORDER BY number ASC;";
    private final Connection connection;

    public PurchaseRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getPurchaseByPurchaseId(UUID purchaseId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_ID = "SELECT * FROM orders WHERE id = " + "'" + purchaseId + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_NUMBER = "SELECT * FROM orders WHERE number = " + "'" + purchaseNumber + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_NUMBER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getPurchaseByCustomerId(UUID customerId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_ID_USER = "SELECT * FROM orders WHERE idcustomer = " + "'" + customerId + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_ID_USER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getPurchaseByCarId(UUID carId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_ID_CAR = "SELECT * FROM orders WHERE idcar = " + "'" + carId + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_ID_CAR);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllPurchases() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_ORDERS);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(UUID customerId, UUID carId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_ORDER = "INSERT INTO orders (idcustomer, idcar) VALUES ('" + customerId + "', '" + carId + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_ORDER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_AN_ORDER = "UPDATE orders SET idcustomer = '" + customerId + "', idcar = '" + carId + "' WHERE id = '" + purchaseId + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_AN_ORDER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(UUID purchaseId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_AN_ORDER = "DELETE FROM orders WHERE id = '" + purchaseId + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_AN_ORDER);
//        statement.close();
        return resultSet;
    }
}
