package com.lpu.service;

import java.util.List;

import com.lpu.dao.StudentDAO;
import com.lpu.entity.Course;
import com.lpu.entity.Student;

public class StudentService {
	private StudentDAO dao = new StudentDAO();
	
	public Student registerStudent(String name, int age, double marks) {
		if(age < 18 || age > 50) 
			throw new IllegalArgumentException("Student age must be in between 18 and 49");
		
		if(marks < 0 || marks > 100) 
			throw new IllegalArgumentException("Invalid marks");
		
		Student student = new Student(name, age, marks);
		
		return dao.saveStudent(student);
	}
	
	public Student getStudentById(int id) {
		Student student = dao.findStudentById(id);
		
		if(student == null)
			throw new IllegalArgumentException("Student not found");
		
		return student;
	}
	
	public void updateMarksById(int id, double newMarks) {
		if(newMarks < 0 || newMarks > 100)
			throw new IllegalArgumentException("Invalid marks");
		
		dao.updateStudentMarks(id, newMarks);
	}
	
	public void deleteStudent(int id) {
		dao.deleteStudentById(id);
	}
	
	public void giveCoursesToStudent(int id, List<Course> courses) {
		dao.giveCoursesToStudent(id, courses);
	}
}
