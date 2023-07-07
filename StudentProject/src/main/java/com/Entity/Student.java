package com.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Student {
	
	@Id
	 private int  studentid;
	 private String Studentname;
	 private int studentmarks;
	 private int studentage;
	public Student() {
		super();
		
	}

	public Student(int studentid, String studentname, int studentmarks, int studentage) {
		super();
		this.studentid = studentid;
		Studentname = studentname;
		this.studentmarks = studentmarks;
		this.studentage = studentage;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return Studentname;
	}

	public void setStudentname(String studentname) {
		Studentname = studentname;
	}

	public int getStudentmarks() {
		return studentmarks;
	}

	public void setStudentmarks(int studentmarks) {
		this.studentmarks = studentmarks;
	}

	public int getStudentage() {
		return studentage;
	}

	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", Studentname=" + Studentname + ", studentmarks=" + studentmarks
				+ ", studentage=" + studentage + "]";
	}
	
	
	 
	 
	 
	

}
