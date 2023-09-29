package repository.impl;

import repository.OrderRepository;

import java.sql.*;

public class OrderRepositoryImpl implements OrderRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_ORDERS = "SELECT * FROM orders ORDER BY number ASC;";
    private final Connection connection;

    public OrderRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_ID = "SELECT * FROM orders WHERE id = " + "'" + id + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByNumber(String number) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_NUMBER = "SELECT * FROM orders WHERE number = " + "'" + number + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_NUMBER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByIdCustomer(String idCustomer) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_ID_USER = "SELECT * FROM orders WHERE idcustomer = " + "'" + idCustomer + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_ID_USER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByIdCar(String idCar) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ORDERS_BY_ID_CAR = "SELECT * FROM orders WHERE idcar = " + "'" + idCar + "'" + " ORDER BY number ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ORDERS_BY_ID_CAR);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllOrders() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_ORDERS);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(String idCustomer, String idCar) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_ORDER = "INSERT INTO orders (idcustomer, idcar) VALUES ('" + idCustomer + "', '" + idCar + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_ORDER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(String id, String idCustomer, String idCar) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_AN_ORDER = "UPDATE orders SET idcustomer = '" + idCustomer + "', idcar = '" + idCar + "' WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_AN_ORDER);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_AN_ORDER = "DELETE FROM orders WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_AN_ORDER);
//        statement.close();
        return resultSet;
    }
}
