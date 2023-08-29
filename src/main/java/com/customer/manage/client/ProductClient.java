package com.customer.manage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.manage.model.ProductModel;

@FeignClient(name="product-service",url="http://localhost:8765",path="/api/v1/product")
public interface ProductClient {
	
	@GetMapping("/findByProductId/{productId}")
	public ProductModel findByProductId(@PathVariable int productId);

	
}
