package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.Student;
import com.Entity.StudentAdress;

@Repository
public class Studentdao {
	
	
	@Autowired
	SessionFactory sf;
	
	public String SaveStudent(Student students) {
		
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Student.class);
		Transaction tr=session.beginTransaction();
		session.save(students);
		tr.commit();
		session.close();
		return "data save";		
	}
	
	public String updateStudent(Student students) {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Student.class);
		Transaction tr = session.beginTransaction();
		session.update(students);
		tr.commit();
		session.close();
		return "data update";
	}
	
	public String DeleteStudent(int studentid) {
		
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(Student.class);
		Transaction tr=session.beginTransaction();
		Student s=session.get(Student.class, studentid);
		session.delete(s);
		tr.commit();
		session.close();
		return "data deleting";
	}
		
		
		public Student GetStudentById(int studentid) {
			
			Session session=sf.openSession();
			Student s=session.get(Student.class, studentid);
			session.close();
			return s;
			
		}
		
		public List<Student> GetAllstudent() {
			
			Session session=sf.openSession();
			Criteria cr= session.createCriteria(Student.class);
			List<Student> l=cr.list();
			session.close();
			return l;
			
	
			}
	
		
		public Student Studentinfo(Student students,int studentaddid)
		{
			System.out.println(studentaddid);
			
			Session session=sf.openSession();
			
			StudentAdress sa=session.load(StudentAdress.class,studentaddid);
			
			System.out.println(sa.getStudents());
			
			
			List<Student> s=sa.getStudents();
						
			Transaction transaction=session.beginTransaction();
			
				s.add(students);
							
			transaction.commit();
					
			
			return students;
			
		}
		
		
		public Student Studentinfo1(Student students,int clasid)
		{
			System.out.println(clasid);
			
			Session session=sf.openSession();
			
			StudentAdress sa=session.load(StudentAdress.class,clasid);
			
			System.out.println(sa.getStudents());
			
			
			List<Student> s=sa.getStudents();
						
			Transaction transaction=session.beginTransaction();
			
				s.add(students);
							
			transaction.commit();
					
			
			return students;
			
		
		}
		
	
	
	

}
