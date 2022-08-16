package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dao.Book;
import kz.halykacademy.bookstore.service.BookServiceRealization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceRealization bookService;

    @PostMapping(path = "/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PostMapping
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return bookService.saveBooks(books);
    }

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/book/{id}")
    public Book findBookByID(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @PutMapping(path = "/{id}/")
    public Book updateBook(@PathVariable long id, @RequestBody Book book) {
        book.setId(id);
        return bookService.updateBook(book);
    }

    @DeleteMapping(path = "/{id}/")
    public String deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }

    @GetMapping(path = "/{name}/")
    public List<Book> findBooksByName(@PathVariable String name) {
        return bookService.findBooksByName(name);
    }

    @GetMapping("/{bookId}/authors/{authorId}/")
    Book bookAuthors(
            @PathVariable long authorId,
            @PathVariable long bookId
    ) {
        return bookService.getBookAuthors(bookId, authorId);
    }


   }
