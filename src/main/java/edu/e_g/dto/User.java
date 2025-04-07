package edu.e_g.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.e_g.util.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long id;

    @NotNull
    @JsonProperty("username")
    private String username;

    @NotNull
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    @Pattern(regexp = "^\\d{9,10}[Vv]?$" ,message = "Please enter 10 Digits or 'V' ")
    private String nic;

    @NotNull
    @JsonProperty("phoneNumber")
    @Pattern(regexp = "^(\\+|0)\\d{9,12}$",message ="Please enter [ (10 Digits) or (+ and country number) ]")
    private String phoneNumber;

    @NotNull
    @JsonProperty("userType")
    private UserType userType;

    @Email(message = "Please enter a valid email")
    @NotNull
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[\\d])[A-Za-z\\d]{5,}$",message ="Please create strong password " )
    private String password;

}
