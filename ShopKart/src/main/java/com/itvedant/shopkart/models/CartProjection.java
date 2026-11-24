package com.itvedant.shopkart.models;

import org.springframework.data.rest.core.config.Projection;

@Projection(types= {Cart.class})
public interface CartProjection {
	public int getId() ;
	public int getQuantity() ;
	public ProductProjection getProduct() ;
	
}
