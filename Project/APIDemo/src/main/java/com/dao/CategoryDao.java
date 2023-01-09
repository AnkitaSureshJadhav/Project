package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	SessionFactory factory;
	
	public Category saveCategory(Category category)
	{
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
				session.save(category);
				
		tx.commit();
		
		return category;
	}
	
	public Category getCategory(int cid)
    {
		
		Session session=factory.openSession();
		
		// get() gives null value if record is not present in database
		
		Category category=session.get(Category.class,cid); // get works only on id
		
//		Criteria criteria=session.createCriteria(Category.class);
//		criteria.add(Restrictions.eq("cid",cid));
//		List<Category> list=criteria.list();
//		Category category=list.get(0);
		
		return category;
//		
    }
	
	

	public List<Category> getAllCategory()
    {
		
		Session session=factory.openSession();
					
		Criteria criteria=session.createCriteria(Category.class);
		
		List<Category> list=criteria.list();
				
		return list;
//		
    }
	
	public Category updateCategory(Category category)
    {
		Session session=factory.openSession();
		
		// criteria API is ONLY FOR retrival (getting data from database)
		
		Transaction tx=session.beginTransaction();
		
			session.update(category);
			
		tx.commit();
		
		return category;
		
    }

	public Category deleteCategory(int cid) {

		Session session=factory.openSession();
		
		// criteria API is ONLY FOR retrival (getting data from database)
		
		Category category=session.get(Category.class,cid); // get works only on id
		
		Transaction tx=session.beginTransaction();
		
			session.delete(category);
			
		tx.commit();
		
		return category;
	
	}

}
