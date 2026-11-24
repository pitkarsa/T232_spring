package com.itvedant.shopkart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.itvedant.shopkart.models.Product;
import com.itvedant.shopkart.models.ProductProjection;

//@CrossOrigin(origins = {"http://localhost:5173"})
@RepositoryRestResource(excerptProjection = ProductProjection.class)
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
