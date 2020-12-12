package ru.pankov.dao;

import org.springframework.stereotype.Repository;
import ru.pankov.entity.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDAOImpl implements ProductDAO {

    List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Banana", new BigDecimal(40)));
        products.add(new Product(2, "Apple", new BigDecimal(70)));
        products.add(new Product(3, "Orange", new BigDecimal(150)));
        products.add(new Product(4, "Grapefruit", new BigDecimal(200)));
        products.add(new Product(5, "Tomato", new BigDecimal(130)));
    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Optional<Product> findById(long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }
}
