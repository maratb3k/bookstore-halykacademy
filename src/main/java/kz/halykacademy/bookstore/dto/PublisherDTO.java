package kz.halykacademy.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublisherDTO {
    private long id;
    private String name;
    private List<BookDTO> publishedBooks;
}
