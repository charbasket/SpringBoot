package com.carlosfuentes.springmongodb;

import com.carlosfuentes.springmongodb.dao.StudentRepository;
import com.carlosfuentes.springmongodb.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class StudentService {

    @Autowired
    private final StudentRepository sRepository;
    public List<Student> getAllStudents(){
        return sRepository.findAll();
    }
}
