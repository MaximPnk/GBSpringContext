package ru.pankov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pankov.config.AppConfig;
import ru.pankov.controller.OrderController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderController orderController = context.getBean("orderController", OrderController.class);

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("/showShop - /showBasket - /add [id] - /remove [id]");

        while (!(command = scanner.nextLine()).equals("/exit")) {
            if (command.equals("/showShop")) {
                orderController.showProducts();
            } else if (command.equals("/showBasket")) {
                orderController.showCart();
            } else if (command.matches("^/add \\d+$")) {
                orderController.addProductToCart(Integer.parseInt(command.split(" ")[1]));
            } else if (command.matches("^/remove \\d+$")) {
                orderController.removeProductFromCart(Integer.parseInt(command.split(" ")[1]));
            } else {
                System.out.println("Wrong command");
            }
        }
    }
}
