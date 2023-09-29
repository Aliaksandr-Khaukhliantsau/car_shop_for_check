//package service.impl;
//
//import entity.Customer;
//import entity.Order;
//import repository.OrderRepository;
//import repository.impl.OrderRepositoryImpl;
//import service.CustomerService;
//import service.OrderService;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderServiceImpl implements OrderService {
//    OrderRepository orderRepository = new OrderRepositoryImpl();
//
//    public OrderServiceImpl() throws SQLException {
//    }
//
//    @Override
//    public List<Order> getOrderById(String id) throws SQLException {
//        ResultSet resultSet = orderRepository.getById(id);
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            String idCustomer = resultSet.getString("idcustomer");
//            CustomerService customerService = new CustomerServiceImpl();
//            order.setCustomer(customerService.getServiceById(idCustomer));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//
//    @Override
//    public List<Order> getByNumber(String number) throws SQLException {
//        ResultSet resultSet = orderRepository.getByNumber(number);
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            order.setCustomer(resultSet.getString("idcustomer"));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//
//    @Override
//    public List<Order> getByIdCustomer(String idCustomer) throws SQLException {
//        ResultSet resultSet = orderRepository.getByIdCustomer(idCustomer);
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            order.setCustomer(resultSet.getString("idcustomer"));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//
//    public List<Order> getByCustomer(Customer customer) throws SQLException {
//        return getByIdCustomer(customer.getId());
//    }
//
//    @Override
//    public List<Order> getByIdCar(String idCar) throws SQLException {
//        ResultSet resultSet = orderRepository.getByIdCar(idCar);
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            order.setCustomer(resultSet.getString("idcustomer"));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//
//    @Override
//    public List<Order> getAllOrders() throws SQLException {
//        ResultSet resultSet = orderRepository.getAllOrders();
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            order.setCustomer(resultSet.getString("idcustomer"));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//
//    @Override
//    public List<Order> create(String idCustomer, String idCar) throws SQLException {
//        ResultSet resultSet = orderRepository.create(idCustomer, idCar);
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            order.setCustomer(resultSet.getString("idcustomer"));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//
//    @Override
//    public List<Order> update(String id, String idCustomer, String idCar) throws SQLException {
//        ResultSet resultSet = orderRepository.update(id, idCustomer, idCar);
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            order.setCustomer(resultSet.getString("idcustomer"));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//
//    @Override
//    public List<Order> delete(String id) throws SQLException {
//        ResultSet resultSet = orderRepository.delete(id);
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setId(resultSet.getString("id"));
//            order.setNumber(resultSet.getInt("number"));
//            order.setCustomer(resultSet.getString("idcustomer"));
//            order.setIdCar(resultSet.getString("idcar"));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }
//}
