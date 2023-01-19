package com.in28minutes.rest.webservices.restfulwebservices.Controllers;

import com.in28minutes.rest.webservices.restfulwebservices.Beans.Post;
import com.in28minutes.rest.webservices.restfulwebservices.Beans.User;
import com.in28minutes.rest.webservices.restfulwebservices.Daos.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.Exceptions.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.Repositories.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa/users")
public class UserJPAController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // We want to add a link to http://localhost:8081/users
    @GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with the id: " + id + " NOT FOUND");
        }
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        userEntityModel.add(link.withRel("all-users"));

        return userEntityModel;
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location =
                ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("{userId}/posts")
    public List<Post> getAllPostsByUserId(@PathVariable int userId) {
        // This is valid, but in this case we have stored all the post in the user, so we don´t have to search between
        // all posts
        /*
        if (userRepository.findById(userId).orElse(null) == null) {
            throw new UserNotFoundException("User with the id: " + userId + " NOT FOUND");
        }
        return postRepository.getPostsByUser_Id(userId);
        */

        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with the id: " + userId + " NOT FOUND");
        }

        return user.getPosts();
    }

    @PostMapping("{userId}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int userId, @RequestBody Post post) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with the id: " + userId + " NOT FOUND");
        }
        post.setUser(user);
        Post savedPost = postRepository.save(post);

        URI location =
                ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
