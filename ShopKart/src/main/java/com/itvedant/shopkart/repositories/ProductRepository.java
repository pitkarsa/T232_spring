package com.itvedant.shopkart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.shopkart.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
