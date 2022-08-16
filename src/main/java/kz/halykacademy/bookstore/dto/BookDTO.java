package kz.halykacademy.bookstore.dto;

import kz.halykacademy.bookstore.dao.Genre;
import kz.halykacademy.bookstore.dao.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {
    private long id;
    private double price;
    private List<AuthorDTO> authors;
    private Publisher publisher;
    private String name;
    private int numOfPages;
    private int productionYear;
    private List<Genre> genres;
}
