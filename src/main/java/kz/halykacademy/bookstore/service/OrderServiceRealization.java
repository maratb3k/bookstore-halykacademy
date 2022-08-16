package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.Book;
import kz.halykacademy.bookstore.dao.Order;
import kz.halykacademy.bookstore.exception.OrderNotFoundException;
import kz.halykacademy.bookstore.exception.PriceExceededException;
import kz.halykacademy.bookstore.exception.UserIsBlockedException;
import kz.halykacademy.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceRealization implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        checkPrice(order);
        checkUser(order);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("The order was not found."));
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public String deleteOrder(long id) {
        orderRepository.deleteById(id);
        return "Order deleted " + id;
    }

    @Override
    public void checkPrice(Order order) {
        List<Book> orderBooks = order.getBooks();
        double totalPrice = 0;
        for(Book b: orderBooks) {
            totalPrice += b.getPrice();
        }
        if(totalPrice > 10000)
            throw new PriceExceededException("The total amount of the order must not exceed 10,000 tenge.");
    }

    @Override
    public void checkUser(Order order) {
        if(order.getUser().isBloked() == true)
            throw new UserIsBlockedException("Access to the order is closed. The user is blocked.");
    }
}
