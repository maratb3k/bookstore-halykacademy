package kz.halykacademy.bookstore.repository;

import kz.halykacademy.bookstore.dao.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
