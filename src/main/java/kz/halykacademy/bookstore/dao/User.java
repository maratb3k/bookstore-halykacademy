package kz.halykacademy.bookstore.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kz.halykacademy.bookstore.dto.UserDTO;
import kz.halykacademy.bookstore.dto.UserRole;
import lombok.*;
import org.springframework.stereotype.Component;
import kz.halykacademy.bookstore.dto.OrderDTO;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "is_bloked")
    private boolean isBloked;

    @Column(name = "orders")
    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    public UserDTO toDto() {
        List<OrderDTO> orders = List.of();
        if (this.orders != null)
            orders = this.orders.stream().map(Order::toDto).toList();
        return new UserDTO(
                this.id,
                this.login,
                this.password,
                this.userRole,
                this.isBloked,
                orders
        );
    }

}
