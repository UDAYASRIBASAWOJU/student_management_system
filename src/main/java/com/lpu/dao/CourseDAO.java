package com.lpu.dao;

import java.util.List;

import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CourseDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	public Course saveCourse(Course course) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(course);
		et.commit();
		em.close();
		
		return course;
	}
	
	public Course findCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		
		Course course = em.find(Course.class, id);
		
		em.close();
		
		return course;
	}
	
	public void updateTrainerNameById(int id, String newTrainer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course course = findCourseById(id);
		
		et.begin();
		if(course != null) {
			course.setTrainer(newTrainer);
			em.merge(course);
		}
		et.commit();
		em.close();
	}
	
	public void deleteCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course course = em.find(Course.class, id);
		
		et.begin();
		if(course != null)
			em.remove(course);
		et.commit();
		em.close();
	}
	
	public void giveStudentsToCourse(int id, List<Student> students) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Course course = em.find(Course.class, id);
		course.setStudents(students);
		
		et.commit();
	}
}
