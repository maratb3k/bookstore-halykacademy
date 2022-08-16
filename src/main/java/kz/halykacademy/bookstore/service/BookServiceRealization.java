package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.Author;
import kz.halykacademy.bookstore.dao.Book;
import kz.halykacademy.bookstore.exception.BookNotFoundException;
import kz.halykacademy.bookstore.repository.AuthorRepository;
import kz.halykacademy.bookstore.repository.BookRepository;
import kz.halykacademy.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceRealization implements BookService {
    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    ///CRUD
    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> saveBooks(List<Book> books) {
        return repository.saveAll(books);
    }

    @Override
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBook(long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book was not found"));
    }

    @Override
    public String deleteBook(long id) {
        repository.deleteById(id);
        return "Book deleted " + id;
    }

    @Override
    public Book updateBook(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> findBooksByName(String name) {
        return repository.findAllByNameContaining(name);
    }

    @Override
    public Book getBookAuthors(long bookId, long authorId) {
        Author author = authorRepository.findById(authorId).get();
        Book book = repository.findById(bookId).get();
        book.getAuthors().add(author);
        return repository.save(book);
    }
}
