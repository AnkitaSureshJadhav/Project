package com.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Category;
import com.model.Product;
import com.model.ProductInfo;


@Repository
public class ProductDao {
	@Autowired
	SessionFactory factory;
	
	public List<Product> allProducts()
	{
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> list=criteria.list();
		return list;
		// [pid=1 name=pen price=100] Product class object
		// Spring calls getter methods to read data of variables and then create JSON String
	}
	
	public Product viewproduct(int pid)
	{
		Session session=factory.openSession();
		
		Product product=session.get(Product.class,pid);
		
		return product;
	
	}
	
	public List<ProductInfo> allProductsWithCategory(int pid)
	{
		Session session=factory.openSession();
		
		Query query=session.createSQLQuery("select product.pid,product.name,product.price,category.cid,category.name as cname from product join category on product.cid=category.cid and pid="+pid);
		
		List<Object[]> list=query.list();
		
		List<ProductInfo> arrayList=new ArrayList<ProductInfo>();
					
		for (Object[] array : list) 
		{
			arrayList.add(new ProductInfo((int)array[0], (String)array[1], (int)array[2], (int)array[3], (String)array[4]));
		}
		
		return arrayList;
	}
	
	
	public Product deleteProduct(int pid)
	{
		Session session=factory.openSession();
		Product product=session.get(Product.class,pid);
		
		Transaction tx=session.beginTransaction();
				session.delete(product);
		tx.commit();
		
		return product;
	}
	
	
	public Product addProduct(Product product,int cid)
	{
		System.out.println("Category id is " + cid);
		
		Session session=factory.openSession();
		
		Category category=session.load(Category.class,cid);
		
		System.out.println("Products from given catergory are :- " + category.getProducts());
		
		/* get list of product and add product into it  */
		
		List<Product> productlist=category.getProducts();
					
		Transaction transaction=session.beginTransaction();
		
			productlist.add(product);
						
		transaction.commit();
				
		System.out.println("product added into database");
		
		return product;
		
	
	}

}
