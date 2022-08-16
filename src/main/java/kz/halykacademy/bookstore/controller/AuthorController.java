package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dao.Author;
import kz.halykacademy.bookstore.service.AuthorServiceRealization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorServiceRealization authorService;

    @PostMapping(path = "/author")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PostMapping
    public List<Author> addAuthors(@RequestBody List<Author> authors) {
        return authorService.saveAuthors(authors);
    }

    @GetMapping
    public List<Author> findAllAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping(path = "/author/{id}")
    public Author findAuthorByID(@PathVariable long id) {
        return authorService.getAuthor(id);
    }

    @PutMapping(path = "/{id}/")
    public Author updateAuthor(@PathVariable long id, @RequestBody Author author) {
        author.setId(id);
        return authorService.updateAuthor(author);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAuthor(@PathVariable long id) {
        return authorService.deleteAuthor(id);
    }

    @GetMapping(path = "/{name}")
    public List<Author> findAuthorsByName(@PathVariable String name) {
        return authorService.findAuthorsByName(name);
    }

    @GetMapping("/{authorId}/books/{bookId}/")
    Author authorBooks(
            @PathVariable long authorId,
            @PathVariable long bookId
    ) {
        return authorService.getAuthorBooks(authorId, bookId);
    }
}
