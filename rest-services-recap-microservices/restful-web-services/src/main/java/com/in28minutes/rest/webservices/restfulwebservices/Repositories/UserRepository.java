package com.in28minutes.rest.webservices.restfulwebservices.Repositories;


import com.in28minutes.rest.webservices.restfulwebservices.Beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer > {
}
