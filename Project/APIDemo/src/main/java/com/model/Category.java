package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Category  {
		
		@Id
		int cid;
		String name;
		@OneToMany(targetEntity = Product.class,cascade= CascadeType.ALL)
		@JoinColumn(name="cid")
		List<Product> products;
		
		public Category() 
		{
			super();
		}
		public Category(int cid, String name, List<Product> products) {
			super();
			this.cid = cid;
			this.name = name;
			this.products = products;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}
		@Override
		public String toString() {
			return "Category [cid=" + cid + ", name=" + name + ", products=" + products + "]";
		}
	}


