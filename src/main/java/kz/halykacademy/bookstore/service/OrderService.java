package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.Order;
import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    Order getOrder(long id);
    List<Order> getOrders();
    Order updateOrder(Order order);
    String deleteOrder(long id);
    void checkPrice(Order order);
    void checkUser(Order order);
}
