package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryDao;
import com.model.Category;

@Service
public class Categoryservice {
	@Autowired
	CategoryDao dao;
	
	
	public Category saveCategory(Category category)
	{
		return dao.saveCategory(category);
		
	}
	
	public Category getCategory(int cid)
    {
		return dao.getCategory(cid);
    }

	public Category updateCategory(Category category) {
		
		return dao.updateCategory(category);
	}

	public Category deleteCategory(int cid) {
		// TODO Auto-generated method stub
		return dao.deleteCategory(cid);
	}
	
	
	public List<Category> getAllCategory()
    {
			return dao.getAllCategory();
    }
}
