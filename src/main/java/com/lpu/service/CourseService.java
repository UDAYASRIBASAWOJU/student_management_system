package com.lpu.service;

import java.util.List;

import com.lpu.dao.CourseDAO;
import com.lpu.entity.Course;
import com.lpu.entity.Student;

public class CourseService {
	
	private CourseDAO coursedao = new CourseDAO();
	
	public Course registerCourse(int id, String name, String trainer) {
		Course course = new Course(id, name, trainer);
		
		return coursedao.saveCourse(course);
	}
	
	public Course getCourseById(int id) {
		Course course = coursedao.findCourseById(id);
		
		if(course == null)
			throw new IllegalArgumentException("Course not found");
		
		return course;
	}
	
	public void updateTrainerById(int id, String newTrainer) {
		coursedao.updateTrainerNameById(id, newTrainer);
	}
	
	public void deleteTrainer(int id) {
		coursedao.deleteCourseById(id);
	}
	
	public void giveStudentsToCourse(int id, List<Student> students) {
		coursedao.giveStudentsToCourse(id, students);
	}
}