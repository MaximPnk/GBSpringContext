package ru.pankov.service;

import ru.pankov.entity.Product;

import java.util.List;

public interface OrderService {

    List<Product> showProducts();

    List<Product> showCart();

    boolean addProductToCart(long id);

    boolean removeProductFromCart(long id);
}
