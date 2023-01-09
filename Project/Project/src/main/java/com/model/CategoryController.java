package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	SessionFactory factory;
	
	@GetMapping("category/{cid}")
	public Category getCategory(@PathVariable int cid) {
		
		Session session= factory.openSession();
		Category category = session.load(Category.class, cid);
		
		return category;
	}
		
		
}
