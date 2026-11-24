package com.itvedant.shopkart.models;

import org.springframework.data.rest.core.config.Projection;

@Projection(types= {Product.class})
public interface ProductProjection {
	public String getDescription() ;
	public int getId();
	public String getName() ;
	public String getCategory() ;
	public int getPrice() ;
	public String getImagePath() ;
}
