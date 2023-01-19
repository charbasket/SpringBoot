package com.in28minutes.rest.webservices.restfulwebservices.Repositories;

import com.in28minutes.rest.webservices.restfulwebservices.Beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> getPostsByUser_Id(int userId);
}
