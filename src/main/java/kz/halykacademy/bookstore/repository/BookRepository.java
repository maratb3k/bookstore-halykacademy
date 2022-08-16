package kz.halykacademy.bookstore.repository;

import kz.halykacademy.bookstore.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findAllByNameContaining(String name);
}
