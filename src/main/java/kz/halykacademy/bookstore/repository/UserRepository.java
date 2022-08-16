package kz.halykacademy.bookstore.repository;

import kz.halykacademy.bookstore.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String username);
}
