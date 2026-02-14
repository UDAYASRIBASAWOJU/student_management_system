package com.lpu.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
	private int id;
	
	private String name;
	
	private String trainer;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public Course() {
		super();
	}

	public Course(int id, String name, String trainer) {
		this.id = id;
		this.name = name;
		this.trainer = trainer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
