package com.onkar.product_management_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer>{

    
}
