package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Student;
import com.service.Studentservice;

@RestController
public class studentController {
	
	
	@Autowired
	Studentservice ss;
	
	@PostMapping("SaveStudent")
	public String save(@RequestBody Student students){
		return ss.save(students);
	}
	
	@PutMapping("UpdateStudent")
	public String update(@RequestBody Student student){
		return ss.update(student);
	}
	
	@DeleteMapping("DeleteStudent/{studentid}")
	public String delete(@PathVariable int studentid){
		return ss.delete(studentid);
		
	}
	
	@RequestMapping("GetByIDStudent/{studentid}")
	public Student getbyid(@PathVariable int studentid) {
		return ss.getbyid(studentid);
	
		
		
	}
	@PostMapping("Savestudentinfo")
	public Student saveStudent(@RequestBody Student students,int studentaddid) {
		return ss.saveStudent(students, studentaddid);
	
	}
	
	@RequestMapping("getStudent")
	public List<Student> getallstudent() {
		return ss.getall();
	}
	
	@PostMapping("Saveclassinfowithclass")
	public Student saveStudent1(@RequestBody Student students,int clasid) {
		return ss.saveStudent1(students, clasid);
}
}
