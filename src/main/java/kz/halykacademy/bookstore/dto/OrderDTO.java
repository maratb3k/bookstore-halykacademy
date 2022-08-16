package kz.halykacademy.bookstore.dto;

import kz.halykacademy.bookstore.dao.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private long id;
    private User user;
    private List<BookDTO> books;
    private OrderStatus status;
    private LocalDateTime orderTime;
}
