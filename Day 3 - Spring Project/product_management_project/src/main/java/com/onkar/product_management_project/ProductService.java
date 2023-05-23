package com.onkar.product_management_project;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;


@Component
public class ProductService {
    private List<Product> products = new ArrayList<>();

    @Autowired
    private ProductDB db;

    public void addProduct(Product p) {
        //products.add(p);
        db.save(p);
    }

    public List<Product> getAllProducts() {
        return db.findAll();
    }

    public Product getProduct(String name) {
        String nameInlowerCase = name.toLowerCase();

        return products
        .stream()
        .filter(productName -> productName.getName().toLowerCase().equals(nameInlowerCase))
        .collect(Collectors.toList()).get(0);
    }

    public List<Product> getAllProductsWithText(String text) {
        String lowerCaseText = text.toLowerCase();

        return products
        .stream()
        .filter(productsWithText -> 
        productsWithText.getName().toLowerCase().equals(lowerCaseText) || 
        productsWithText.getType().toLowerCase().equals(lowerCaseText) || 
        productsWithText.getPlace().toLowerCase().equals(lowerCaseText))
        .collect(Collectors.toList());
    }

    public List<Product> getAllProductsOfPlace(String place) {
        return products
        .stream()
        .filter(productsPlace -> productsPlace.getPlace()
        .toLowerCase()
        .equals(place.toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<Product> getAllOutOfWarrantyProducts(int warranty) {
        return products
        .stream()
        .filter(productsWarranty -> productsWarranty.getWarranty() <= warranty)
        .collect(Collectors.toList());
    }
}