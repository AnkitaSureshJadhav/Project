package com.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.model.ProductInfo;
import com.service.Productservice;


@RequestMapping("productapi")
@RestController
public class ProductController{
	@Autowired
	Productservice service;
	
	@RequestMapping("allProducts")
	public List<Product> allProducts()
	{
		
		return service.allProducts();
	}
	
	@RequestMapping("viewproduct/{pid}")
    public Product viewproduct(@PathVariable int pid)
	{
		return service.viewproduct(pid);
	}
	
	@RequestMapping("allProductsWithCategory/{pid}")
	public List<ProductInfo> allProductsWithCategory(@PathVariable int pid)
	{
		return service.allProductsWithCategory(pid);
	}
	
	@RequestMapping("deleteProduct/{pid}")
	public Product deleteProduct(@PathVariable int pid)
	{
		return service.deleteProduct(pid);
	}
	
	
}

