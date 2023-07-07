package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.StudentAdress;
import com.dao.studentadddao;

@Service
public class Studentaddservice {
	
	
	@Autowired
	studentadddao sc;
	
	public String save(StudentAdress students) {
		return sc.saveStudentAddress(students);
	}
	
	public String update(StudentAdress students) {
		return sc.UpdateStudentAdress(students);
	}
	
	public String delet(int  studentaddid) {
		return sc.DeleteStudentAdress(studentaddid);
	}

	public List<StudentAdress> getall() {
		return sc.GettAlladress();
	}
	
	public StudentAdress getbyid(int  studentaddid) {
		return sc.getbyid(studentaddid);

	}
	
	
	
	
	
	

}
