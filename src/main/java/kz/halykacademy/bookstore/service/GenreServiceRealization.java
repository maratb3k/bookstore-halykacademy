package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.Genre;
import kz.halykacademy.bookstore.exception.BookNotFoundException;
import kz.halykacademy.bookstore.exception.GenreNotFoundException;
import kz.halykacademy.bookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreServiceRealization implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> saveGenres(List<Genre> genres) {
        return genreRepository.saveAll(genres);
    }

    @Override
    public Genre getGenre(long id) {
        return genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("The genre was not found"));
    }

    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public String deleteGenre(long id) {
        genreRepository.deleteById(id);
        return "Genre with id " + id + " removed";
    }
}
