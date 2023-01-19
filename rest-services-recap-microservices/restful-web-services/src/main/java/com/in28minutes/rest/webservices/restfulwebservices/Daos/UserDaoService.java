package com.in28minutes.rest.webservices.restfulwebservices.Daos;

import com.in28minutes.rest.webservices.restfulwebservices.Beans.Post;
import com.in28minutes.rest.webservices.restfulwebservices.Beans.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30), Arrays.asList(new Post())));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25), Arrays.asList(new Post())));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20), Arrays.asList(new Post())));
        users.add(new User(4, "Carlos", LocalDate.now().minusYears(10), Arrays.asList(new Post())));
    }
    private static Integer usersCount = 3;

    public List<User> findAll(){
        return users;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        // User deletedUser = this.findOne(id);
        // users.remove(deletedUser);
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
