package com.itvedant.productcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itvedant.productcrud.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	// db interaction
	// inbuilt methods for all CRUD operations
	// save(object) - insert, update - returns the object from db
	// findAll()   - Iterable<Product>
	// findById(id) - single product obj
	// deleteById(id) 
	
	
}
