package com.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class studentclass {
	
	@Id
	private int clasid;
	private String classs;
	
	
	@OneToMany(targetEntity =Student.class,cascade = CascadeType.ALL)
	@JoinColumn(name="clasid")
	 private List<Student> students;

	public studentclass() {
		
	}

	public studentclass(int clasid, String classs, List<Student> students) {
		super();
		this.clasid = clasid;
		this.classs = classs;
		this.students = students;
	}


public int getClasid() {
	return clasid;
	}


	public void setClasid(int clasid) {
		this.clasid = clasid;
	}


	public String getClasss() {
		return classs;
}

public void setClasss(String classs) {
	this.classs = classs;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
	return "studentdivision [clasid=" + clasid + ", classs=" + classs + ", students=" + students + "]";
}

}
