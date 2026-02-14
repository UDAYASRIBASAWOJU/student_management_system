package com.lpu.controller;

import com.lpu.service.CourseService;

public class CourseController {
	private static CourseService cService = new CourseService();
	
	public static void main(String[] args) {
		cService.updateTrainerById(202, "Oggy");
	}

}
