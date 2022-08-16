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
public class UserDTO {
    private long id;
    private String login;
    private String password;
    private UserRole userRole;
    private boolean isBloked;
    private List<OrderDTO> orders;
}
