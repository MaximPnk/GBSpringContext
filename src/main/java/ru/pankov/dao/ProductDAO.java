package ru.pankov.dao;

import ru.pankov.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    List<Product> findAll();

    Optional<Product> findById(long id);
}
