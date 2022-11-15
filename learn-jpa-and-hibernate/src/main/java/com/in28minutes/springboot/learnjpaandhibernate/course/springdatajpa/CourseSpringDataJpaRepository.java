package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	// Podemos añadir metodos propios a parte de lo de JpaRepository
	// Para buscar siempre tiene que ser findBy + nombre del campo por el que
	// quieres buscar
	List<Course> findByAuthor(String author);

	List<Course> findByName(String name);
}
