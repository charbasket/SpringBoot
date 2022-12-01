package com.carlosfuentes.springmongodb.dao;

import com.carlosfuentes.springmongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
