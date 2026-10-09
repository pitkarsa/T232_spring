package com.itvedant.productcrud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itvedant.productcrud.models.Product;
import com.itvedant.productcrud.repositories.ProductRepository;

@Service
public class ProductService {
	
//	@Autowired
//	private ProductRepository productRepository;
	
	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product addProduct(Product product) {
		// add the product to db using repository
		Product dbProduct = productRepository.save(product);
		System.out.println("product obejct received from repository:"+ dbProduct);
		// send the newly added product object to controller
		return dbProduct;
	}
	
	public Iterable<Product> getAllProducts(){
		Iterable<Product> allProducts= productRepository.findAll();
		return allProducts;
	}
	
	public Product getProductById(int id) {
		Product requiredProduct = productRepository.findById(id).get();
		return requiredProduct;
	}
	
	
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}
	
	public Product updateProductById(Product product) {
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
