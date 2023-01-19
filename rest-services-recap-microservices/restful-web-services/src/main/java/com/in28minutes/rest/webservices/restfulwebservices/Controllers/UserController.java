package com.in28minutes.rest.webservices.restfulwebservices.Controllers;

import com.in28minutes.rest.webservices.restfulwebservices.Beans.User;
import com.in28minutes.rest.webservices.restfulwebservices.Daos.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.Exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    // We want to add a link to http://localhost:8081/users
    @GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {
        User user = userDaoService.findById(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        userEntityModel.add(link.withRel("all-users"));

        return userEntityModel;
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.createUser(user);
        URI location =
                ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userDaoService.deleteById(id);
    }
}
