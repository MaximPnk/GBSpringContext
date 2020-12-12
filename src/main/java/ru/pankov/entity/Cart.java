package ru.pankov.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private final List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }
}
