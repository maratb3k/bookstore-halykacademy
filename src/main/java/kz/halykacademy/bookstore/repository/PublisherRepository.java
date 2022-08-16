package kz.halykacademy.bookstore.repository;

import kz.halykacademy.bookstore.dao.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    public List<Publisher> findAllByNameContaining(String name);
}
