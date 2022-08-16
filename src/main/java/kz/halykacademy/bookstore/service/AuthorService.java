package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.Author;
import java.util.List;

public interface AuthorService {

    Author saveAuthor(Author author);
    List<Author> saveAuthors(List<Author> authors);
    Author getAuthor(long id);
    List<Author> getAuthors();
    Author updateAuthor(Author author);
    String deleteAuthor(long id);

    public List<Author> findAuthorsByName(String name);

    Author getAuthorBooks(long authorId, long bookId);
}
