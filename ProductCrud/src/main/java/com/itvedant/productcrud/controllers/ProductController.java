package com.itvedant.productcrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.productcrud.models.Product;
import com.itvedant.productcrud.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	/*
	// 1. adding new product to db
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
//		System.out.println("product object received from client/postman:"+product);
		// send the product object to service class
		Product dbProduct = productService.addProduct(product);
		return dbProduct;
	}
	
	@GetMapping("/products")
	public  Iterable<Product>  getAllProducts() {
		Iterable<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}
	
	
	// "http://localhost:8080/products/4"  GET
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
//		System.out.println("path variable id:"+id);
		Product requiredProduct = productService.getProductById(id);
		return requiredProduct;
	}
	
	// "http://localhost:8080/products/2"  DELETE
	@DeleteMapping("/products/{id}")
	public String deleteProductById(@PathVariable int id) {
		productService.deleteProductById(id);
		return "Product deleted successfully";
	}
	
	// "http://localhost:8080/products/1" PUT, with JSON
	@PutMapping("/products/{id}")
	public Product updateProductById(@PathVariable int id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProductById(product);
		return updatedProduct;
	}
	*/
	
	
	
	// 1. adding new product to db
		@PostMapping("/products")
		public ResponseEntity<?> addProduct(@RequestBody Product product) {
			// send the product object to service class
			Product dbProduct = productService.addProduct(product);
			return new ResponseEntity<>(dbProduct, HttpStatus.CREATED);
		}
	
		// fetching all products
		@GetMapping("/products")
		public  ResponseEntity<?>  getAllProducts() {
			Iterable<Product> allProducts = productService.getAllProducts();
			return new ResponseEntity<>(allProducts, HttpStatus.OK);
		}
		
		// fetching single product
		// "http://localhost:8080/products/4"  GET
		@GetMapping("/products/{id}")
		public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
			Product requiredProduct = productService.getProductById(id);
			return new ResponseEntity<>(requiredProduct, HttpStatus.OK);
		}
	
		// "http://localhost:8080/products/2"  DELETE
		@DeleteMapping("/products/{id}")
		public ResponseEntity<?> deleteProductById(@PathVariable int id) {
			productService.deleteProductById(id);
			return new ResponseEntity<>("Product deleted successfully", HttpStatus.NO_CONTENT);
		}
	
	
		// updating product by id
		// "http://localhost:8080/products/1" PUT, with JSON
		@PutMapping("/products/{id}")
		public ResponseEntity<?> updateProductById(@PathVariable int id, @RequestBody Product product) {
			Product updatedProduct = productService.updateProductById(product);
			return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		}
	
		
		
	
	
	
	
	
	
	
	
}
