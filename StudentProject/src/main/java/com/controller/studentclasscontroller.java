package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.studentclass;
import com.service.studentclassservice;

@RestController
public class studentclasscontroller {
	
	
	
	@Autowired
	studentclassservice sc;
	
	@PostMapping("saveclass")
	public String saveclass(@RequestBody studentclass ss ) {
		return sc.saveclass(ss);
	}
	
	@PutMapping("updateclass")
	public String update(@RequestBody studentclass ss ) {
		return sc.updateclass(ss);
	}
	
	@DeleteMapping("deleteclass/{clasid}")
	public String delete(@PathVariable int clasid) {
		return sc.delete(clasid);
	}
	
	@RequestMapping("GetAllClass")
	public List<studentclass> getallclass() {
		return sc.gellallclass();
	}
	
	@RequestMapping("getclassbyid/{clasid}")
	public studentclass grtbyidclass(@PathVariable int  clasid) {
		return sc.getclaaid(clasid);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
