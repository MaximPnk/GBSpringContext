package ru.pankov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pankov.dao.ProductDAO;
import ru.pankov.entity.Cart;
import ru.pankov.entity.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    ProductDAO productDAO;
    Cart cart;

    @Autowired
    public OrderServiceImpl(ProductDAO productDAO, Cart cart) {
        this.productDAO = productDAO;
        this.cart = cart;
    }

    @Override
    public List<Product> showProducts() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> showCart() {
        return Collections.unmodifiableList(cart.getProducts());
    }

    @Override
    public boolean addProductToCart(long id) {

        if (cart.getProducts().stream().anyMatch(p -> p.getId() == id)) {
            return false;
        }

        Optional<Product> product = productDAO.findById(id);
        product.ifPresent(value -> cart.getProducts().add(value));
        return product.isPresent();
    }

    @Override
    public boolean removeProductFromCart(long id) {
        Optional<Product> product = cart.getProducts().stream().filter(p -> p.getId() == id).findFirst();
        product.ifPresent(value -> cart.getProducts().remove(value));
        return product.isPresent();
    }
}
