package kz.halykacademy.bookstore.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kz.halykacademy.bookstore.dto.AuthorDTO;
import kz.halykacademy.bookstore.dto.BookDTO;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(scope = Book.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(name = "books_authors", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    @Column(name = "name")
    private String name;

    @Column(name = "numofpages")
    private int numOfPages;

    @Column(name = "productionyear")
    private int productionYear;

    @ManyToMany
    @JoinTable(name = "books_genres", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    public BookDTO toDto() {
        List<AuthorDTO> authors = List.of();
        if (this.authors != null)
            authors = this.authors.stream().map(Author::toDto).toList();
        return new BookDTO(
                this.id,
                this.price,
                authors,
                publisher,
                this.name,
                this.numOfPages,
                this.productionYear,
                genres
        );
    }

    public void getBookAuthors(Author author) {
        authors.add(author);
    }

    public void assignPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
