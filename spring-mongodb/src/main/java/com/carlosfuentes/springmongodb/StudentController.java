package com.carlosfuentes.springmongodb;

import com.carlosfuentes.springmongodb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private  StudentService sService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return sService.getAllStudents();
    }
}
