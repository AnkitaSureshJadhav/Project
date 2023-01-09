package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ProductDao;
import com.model.Product;
import com.model.ProductInfo;


@Service
public class Productservice {
	 @Autowired
     ProductDao dao;
     
  public Product addProduct(Product product,int cid)
 	{
  		return dao.addProduct(product, cid);
 	}
	public List<Product> allProducts()
	{
		return dao.allProducts();
	}
	
	public Product viewproduct(int pid)
	{
		return dao.viewproduct(pid);
	}

	public List<ProductInfo> allProductsWithCategory(int pid)
	{
		return dao.allProductsWithCategory(pid);
	}
	
	public Product deleteProduct(int pid)
	{
		return dao.deleteProduct(pid);
	}
	
}



