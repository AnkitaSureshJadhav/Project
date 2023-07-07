package com.Entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class StudentAdress {
	
	
	@Id
	 private int studentaddid;
	 private  String studadress;
	 
	 @OneToMany(targetEntity =Student.class,cascade = CascadeType.ALL)
		@JoinColumn(name="studentaddid")
		 private List<Student> students;
	 
	 public StudentAdress() {
		 
	 }

	public StudentAdress(int studentaddid, String studadress, List<Student> students) {
		super();
		this.studentaddid = studentaddid;
		this.studadress = studadress;
		this.students = students;
	}

	public int getStudentaddid() {
		return studentaddid;
	}

	public void setStudentaddid(int studentaddid) {
		this.studentaddid = studentaddid;
	}

	public String getStudadress() {
		return studadress;
	}

	public void setStudadress(String studadress) {
		this.studadress = studadress;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	
	}
}