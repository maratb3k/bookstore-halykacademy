package kz.halykacademy.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorDTO {
    private long id;
    private String surname;
    private String name;
    private String middlename;
    private LocalDate dateOfBirth;
    private List<BookDTO> books;
    private List<GenreDTO> genres;
}
