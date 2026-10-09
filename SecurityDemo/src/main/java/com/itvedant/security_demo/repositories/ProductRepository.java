package com.itvedant.security_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.security_demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
