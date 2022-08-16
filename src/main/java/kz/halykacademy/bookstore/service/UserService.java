package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    User getUser(long id);
    List<User> getUsers();
    User updateUser(User user);
    String deleteUser(long id);

}
