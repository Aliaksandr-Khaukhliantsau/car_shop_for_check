package repository.impl;

import repository.PurchaseRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class PurchaseRepositoryImpl implements PurchaseRepository {
    private static final String SQL_GET_PURCHASE_BY_PURCHASE_ID = "SELECT * FROM orders WHERE id = ? ORDER BY number ASC;";
    private static final String SQL_GET_PURCHASE_BY_PURCHASE_NUMBER = "SELECT * FROM orders WHERE number = ? ORDER BY number ASC;";
    private static final String SQL_GET_PURCHASE_BY_CUSTOMER_ID = "SELECT * FROM orders WHERE idcustomer = ? ORDER BY number ASC;";
    private static final String SQL_GET_PURCHASE_BY_CAR_ID = "SELECT * FROM orders WHERE idcar = ? ORDER BY number ASC;";
    private static final String SQL_GET_ALL_PURCHASES = "SELECT * FROM orders ORDER BY number ASC;";
    private static final String SQL_CREATE_A_PURCHASE = "INSERT INTO orders (idcustomer, idcar) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_PURCHASE = "UPDATE orders SET idcustomer = ?, idcar = ? WHERE id = ? RETURNING *;";
    private static final String SQL_DELETE_A_PURCHASE = "DELETE FROM orders WHERE id = ? RETURNING *;";
    private final Connection connection;

    public PurchaseRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public ResultSet getPurchaseByPurchaseId(UUID purchaseId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_PURCHASE_ID);
        preparedStatement.setObject(1, purchaseId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_PURCHASE_NUMBER);
        preparedStatement.setInt(1, Integer.parseInt(purchaseNumber));
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getPurchaseByCustomerId(UUID customerId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_CUSTOMER_ID);
        preparedStatement.setObject(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getPurchaseByCarId(UUID carId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PURCHASE_BY_CAR_ID);
        preparedStatement.setObject(1, carId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getAllPurchases() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_PURCHASES);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public void create(UUID customerId, UUID carId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_PURCHASE);
        preparedStatement.setObject(1, customerId);
        preparedStatement.setObject(2, carId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_PURCHASE);
        preparedStatement.setObject(1, customerId);
        preparedStatement.setObject(2, carId);
        preparedStatement.setObject(3, purchaseId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void delete(UUID purchaseId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_PURCHASE);
        preparedStatement.setObject(1, purchaseId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }
}
