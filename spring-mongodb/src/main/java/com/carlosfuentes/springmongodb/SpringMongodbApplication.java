package com.carlosfuentes.springmongodb;

import com.carlosfuentes.springmongodb.dao.StudentRepository;
import com.carlosfuentes.springmongodb.entity.Adress;
import com.carlosfuentes.springmongodb.entity.Gender;
import com.carlosfuentes.springmongodb.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository rRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Adress adress = new Adress("Spain", "Madrid", "28034");
            String email = "carlos@hotmail.com";
            Student student = new Student("Carlos", "Fuentes", email, Gender.MALE, adress,
                    List.of("Computer Science", "Math"), BigDecimal.TEN, LocalDateTime.now());

            //UsingMongoTemplateAndQuery(rRepository, mongoTemplate, email, student);
            rRepository.findStudentByEmail(email).ifPresentOrElse( s-> {
                System.out.println(s + " already exist");
            }, ()-> {
                System.out.println("Inserting student" + student);
                rRepository.save(student);
            });
        };

    }

    private static void UsingMongoTemplateAndQuery(StudentRepository rRepository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        List<Student> students = mongoTemplate.find(query, Student.class);
        if (students.size() > 1) {
            throw new IllegalStateException("Found many students with email" + email);
        }
        if (students.isEmpty()) {
            System.out.println("Inserting student" + student);
            rRepository.save(student);
        } else {
            System.out.println(student + " already exist");
        }
    }

}
