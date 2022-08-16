package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dao.Genre;
import kz.halykacademy.bookstore.service.GenreServiceRealization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreServiceRealization genreService;


    @PostMapping(path = "/genre")
    public Genre addGenre(@RequestBody Genre genre) {
        return genreService.saveGenre(genre);
    }

    @PostMapping
    public List<Genre> addGenres(@RequestBody List<Genre> genres) {
        return genreService.saveGenres(genres);
    }

    @GetMapping
    public List<Genre> findAllGenres() {
        return genreService.getGenres();
    }

    @GetMapping(path = "/{id}/")
    public Genre findGenreByID(@PathVariable long id) {
        return genreService.getGenre(id);
    }

    @PutMapping(path = "/{id}/")
    public Genre updateGenre(@PathVariable long id, @RequestBody Genre genre) {
        genre.setId(id);
        return genreService.updateGenre(genre);
    }

    @DeleteMapping(path = "/{id}/")
    public String deleteGenre(@PathVariable long id) {
        return genreService.deleteGenre(id);
    }

}
