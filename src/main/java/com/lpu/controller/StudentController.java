package com.lpu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lpu.entity.Course;
import com.lpu.service.StudentService;

public class StudentController {
	
	private static StudentService service = new StudentService();
	
	public static void main(String[] args) {
		service.registerStudent("A", 21, 35.55);
		
		service.registerStudent("B", 20, 99.8);
		
		List<Course> courses = new ArrayList<>(Arrays.asList(new Course(201, "Java", "Tom"), new Course(202, "SQL", "Jerry")));
		
		service.giveCoursesToStudent(1, courses);
		
	}
}
