package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.studentclass;

@Repository
public class studentclassdao {
	@Autowired
	SessionFactory sf;
	
	
	public String saveStudentclass(studentclass sc) {
		
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(studentclass.class);
		Transaction tr= session.beginTransaction();
		session.save(sc);
		tr.commit();
		session.close();
		return "Save class";
	}
	
	public String UpdateStudentclass(studentclass sc) {
		Session session= sf.openSession();
		Criteria cr=session.createCriteria(studentclass.class);
		Transaction tr= session.beginTransaction();
		session.update(sc);
		tr.commit();
		session.close();
		return "update student class";
	}
	
	
	public String DeleteStudentclass( int clasid) {
		
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(studentclass.class);
		Transaction tr=session.beginTransaction();
		studentclass sa=session.get(studentclass.class,clasid );
		session.delete(sa);
		tr.commit();
		session.close();
		return "data deleting";
	}
	
	public List<studentclass> GettAllclass() {
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(studentclass.class);
		 List<studentclass> as=cr.list();
		session.close();
		return as;
		
	}
	
	public studentclass getbyid(int  clasid) {
		Session session=sf.openSession();
		studentclass sc= session.get(studentclass.class, clasid);
		session.close();
		return sc;
		
	
		
		
		
		
	}

}
