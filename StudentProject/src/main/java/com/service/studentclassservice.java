package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.studentclass;
import com.dao.studentclassdao;


@Service
public class studentclassservice {
	

	@Autowired
	studentclassdao sc;
	
	public String saveclass(studentclass ss) {
		
		 return sc.saveStudentclass(ss);
	}
	
	
	public String updateclass(studentclass ss) {
		 return sc.UpdateStudentclass(ss);
	}
	
	public String delete(int clasid) {
		return sc.DeleteStudentclass(clasid);
	}
	
	public List<studentclass>  gellallclass() {
		 return sc.GettAllclass();
	}
	
	public studentclass getclaaid(int clasid) {
		return sc.getbyid(clasid);
	}
}