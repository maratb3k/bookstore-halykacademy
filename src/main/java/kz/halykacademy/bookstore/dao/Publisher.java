package kz.halykacademy.bookstore.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kz.halykacademy.bookstore.dto.BookDTO;
import kz.halykacademy.bookstore.dto.PublisherDTO;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Publisher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    //teacher - publisher 1
    // subject - book  many
    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private List<Book> publishedBooks;

    public PublisherDTO toDto() {
        List<BookDTO> publishedBooks = List.of();
        if (this.publishedBooks != null)
            publishedBooks = this.publishedBooks.stream().map(Book::toDto).toList();
        return new PublisherDTO(
                this.id,
                this.name,
                publishedBooks
        );
    }
}
