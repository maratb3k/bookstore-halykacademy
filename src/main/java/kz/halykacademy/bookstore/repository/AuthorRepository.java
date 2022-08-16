package kz.halykacademy.bookstore.repository;

import kz.halykacademy.bookstore.dao.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    public List<Author> findAllByNameContaining(String name);
}
