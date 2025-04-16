package edu.e_g.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.e_g.util.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    @JsonProperty("userId")
    private Long userId;

    @NotNull
    private String name;

    @NotNull
    @Pattern(regexp = "^\\d{9,10}[Vv]?$" ,message = "Please enter 10 Digits or 'V' ")
    private String nic;

    @NotNull
    @JsonProperty("phoneNumber")
    @Pattern(regexp = "^0\\d{9}$\n",message ="Please enter 10 Digits")
    private String phoneNumber;

    @Email(message = "Please enter a valid email")
    @NotNull
    private String email;

    @NotNull
    @JsonProperty("userType")
    private UserType userType;

    @NotNull
    @JsonProperty("username")
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[\\d])[A-Za-z\\d]{5,}$",message ="Please create strong password " )
    private String password;
}
