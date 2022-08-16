package kz.halykacademy.bookstore.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kz.halykacademy.bookstore.dto.AuthorDTO;
import kz.halykacademy.bookstore.dto.BookDTO;
import kz.halykacademy.bookstore.dto.GenreDTO;
import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
@JsonIdentityInfo(scope = Author.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "authors")
//    @JoinTable(name = "books_authors",
//            joinColumns = @JoinColumn(
//                    name = "author_id",
//                    referencedColumnName = "id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "book_id",
//                    referencedColumnName = "id"
//            )
//    )
    private List<Book> books = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "authors_genres", joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();

    public Author() {}


    public AuthorDTO toDto() {

        List<BookDTO> books = List.of();
        if (this.books != null)
            books = this.books.stream().map(Book::toDto).toList();

        List<GenreDTO> genres = List.of();
        if (this.genres != null)
            genres = this.genres.stream().map(Genre::toDto).toList();

        return new AuthorDTO(
                this.id,
                this.surname,
                this.name,
                this.middlename,
                this.dateOfBirth,
                books,
                genres
        );
    }

    public void getAuthorBooks(Book book) {
        books.add(book);
    }
}
