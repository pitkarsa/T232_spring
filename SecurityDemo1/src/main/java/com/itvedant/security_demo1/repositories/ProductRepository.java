package com.itvedant.security_demo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.security_demo1.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
