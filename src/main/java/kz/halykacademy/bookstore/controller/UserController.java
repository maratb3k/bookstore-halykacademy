package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dao.User;
import kz.halykacademy.bookstore.service.UserServiceRealization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserServiceRealization userService;


    @PostMapping(path = "/user")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/user/{id}")
    public User findUserByID(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PutMapping(path = "/{id}/")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

}
