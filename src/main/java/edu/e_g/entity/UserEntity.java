package edu.e_g.entity;

import edu.e_g.util.UserType;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String nic;
    private String phoneNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String username;
    private String password;
}
