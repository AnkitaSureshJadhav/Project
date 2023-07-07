package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.dao.Studentdao;

@Service
public class Studentservice {

	
	@Autowired
	Studentdao dao;
	
	
	public String save(Student students) {
		 return dao.SaveStudent(students);
		
		
		
	}
	
	public String update(Student students) {
		return dao.updateStudent(students);
	}
	
	
	public String delete(int studentid) {
		return dao.DeleteStudent(studentid);
	}
	
	
	public List<Student> getall() {
		return dao.GetAllstudent();
	}
	
	public Student getbyid(int studentid) {
		 return dao.GetStudentById(studentid);
	
		
	}
	
	public Student saveStudent(Student students,int studentaddid) {
		 return dao.Studentinfo( students,studentaddid);
	}
	
	public Student saveStudent1(Student students,int clasid) {
		 return dao.Studentinfo1( students,clasid);
	
}
}
