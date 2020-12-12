package ru.pankov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.pankov.service.OrderService;

@Controller
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void showProducts() {
        System.out.println(orderService.showProducts());
    }

    public void showCart() {
        System.out.println(orderService.showCart());
    }

    public void addProductToCart(long id) {
        if (orderService.addProductToCart(id)) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Incorrect id or product already in your cart");
        }
    }

    public void removeProductFromCart(long id) {
        if (orderService.removeProductFromCart(id)) {
            System.out.println("Successfully removed");
        } else {
            System.out.println("There is no product in basket with id = " + id);
        }
    }
}
