package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dao.Order;
import kz.halykacademy.bookstore.service.OrderServiceRealization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders/")
public class OrderController {
    @Autowired
    private OrderServiceRealization orderService;

    @PostMapping(path = "/order")
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.getOrders();
    }

    @GetMapping(value = "/order/{id}/")
    public Order findOrderByID(@PathVariable long id) {
        return orderService.getOrder(id);
    }

    @PutMapping(value = "/{id}/")
    public Order updateOrder(@PathVariable long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.updateOrder(order);
    }

    @DeleteMapping(value = "/{id}/")
    public String deleteOrder(@PathVariable long id) {
        return orderService.deleteOrder(id);
    }

}
