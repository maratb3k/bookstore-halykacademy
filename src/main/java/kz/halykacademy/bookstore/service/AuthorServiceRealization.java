package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.Author;
import kz.halykacademy.bookstore.dao.Book;
import kz.halykacademy.bookstore.exception.AuthorNotFoundException;
import kz.halykacademy.bookstore.repository.AuthorRepository;
import kz.halykacademy.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorServiceRealization implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public AuthorServiceRealization(AuthorRepository repository) {
        this.authorRepository = repository;
    }


    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> saveAuthors(List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    @Override
    public Author getAuthor(long id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("The author was not found"));
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public String deleteAuthor(long id) {
        authorRepository.deleteById(id);
        return "Author deleted " + id;
    }

    @Override
    public List<Author> findAuthorsByName(String name) {
        return authorRepository.findAllByNameContaining(name);
    }

    @Override
    public Author getAuthorBooks(long authorId, long bookId) {
        Author author = authorRepository.findById(authorId).get();
        Book book = bookRepository.findById(bookId).get();
        author.getBooks().add(book);
        return authorRepository.save(author);
    }
}
