package com.itvedant.shopkart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.itvedant.shopkart.models.Cart;
import com.itvedant.shopkart.models.CartProjection;

@RepositoryRestResource(excerptProjection = CartProjection.class)
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
