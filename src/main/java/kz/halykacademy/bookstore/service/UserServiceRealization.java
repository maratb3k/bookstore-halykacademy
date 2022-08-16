package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.User;
import kz.halykacademy.bookstore.exception.UserNotFoundException;
import kz.halykacademy.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceRealization implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "User deleted " + id;
    }
}
