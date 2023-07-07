package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.StudentAdress;
import com.service.Studentaddservice;

@RestController
public class studentaddcontroller {
	
	
	@Autowired
	Studentaddservice ss;
	
	@PostMapping("SaveStudentAddress")
	public String save(@RequestBody StudentAdress students) {
	return ss.save(students);
	}
	
	
	@PutMapping("UpdateStudentAddress")
	public String update(@RequestBody  StudentAdress students) {
	return ss.update(students);
	}
	
	@DeleteMapping("DeleteStudentAddress/{studentaddid}")
	public String delete(@PathVariable int studentaddid ) {
		return ss.delet(studentaddid);
	}
	
	
	@RequestMapping("GetAllStudentAddress")
	public List<StudentAdress>getAll() {
		return ss.getall();
	}
	
	@RequestMapping("GetByIdStudentAddress/{studentaddid}")
	public StudentAdress getbyid(@PathVariable int studentaddid) {
		return ss.getbyid(studentaddid);
	}

}
