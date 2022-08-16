package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.Genre;
import java.util.List;

public interface GenreService {
    Genre saveGenre(Genre genre);
    List<Genre> saveGenres(List<Genre> genres);
    Genre getGenre(long id);
    List<Genre> getGenres();
    Genre updateGenre(Genre genre);
    String deleteGenre(long id);

}
