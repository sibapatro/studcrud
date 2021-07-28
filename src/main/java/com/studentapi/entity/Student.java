package com.studentapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Student {
	
	public Student(Integer id, String firstName, String lastName, String studentClass, String nationality) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentClass = studentClass;
		this.nationality = nationality;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	private String firstName;
	
	private String lastName;
	
	private String studentClass;
	
	private String nationality;
	
}
 