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
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String nic;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String email;
    private String password;
}
