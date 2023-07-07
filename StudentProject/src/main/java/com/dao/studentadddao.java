package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.StudentAdress;

@Repository
public class studentadddao {
	
	@Autowired
	SessionFactory sf;
	
	
	public String saveStudentAddress(StudentAdress stud) {
		
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(StudentAdress.class);
		Transaction tr= session.beginTransaction();
		session.save(stud);
		tr.commit();
		session.close();
		return "Save Student";
	}
	
	public String UpdateStudentAdress(StudentAdress stud) {
		Session session= sf.openSession();
		Criteria cr=session.createCriteria(StudentAdress.class);
		Transaction tr= session.beginTransaction();
		session.update(stud);
		tr.commit();
		session.close();
		return "update student address";
	}
	
	
	public String DeleteStudentAdress( int studentaddid) {
		
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(StudentAdress.class);
		Transaction tr=session.beginTransaction();
		StudentAdress sa=session.get(StudentAdress.class,studentaddid );
		session.delete(sa);
		tr.commit();
		session.close();
		return "data deleting";
	}
	
	public List<StudentAdress> GettAlladress() {
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(StudentAdress.class);
		 List<StudentAdress> as=cr.list();
		session.close();
		return as;
		
	}
	
	public StudentAdress getbyid(int  studentaddid) {
		Session session=sf.openSession();
		StudentAdress sa= session.get(StudentAdress.class, studentaddid);
		session.close();
		return sa;
		
	
		
		
		
		
	}
	
	

}
