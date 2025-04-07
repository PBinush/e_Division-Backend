package edu.e_g.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.e_g.util.GenderType;
import edu.e_g.util.IsActiveType;
import edu.e_g.util.maritalStatusType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    @NotNull
    @Pattern(regexp = "^\\d{9,10}[Vv]?$" ,message = "Please give 10 Digits or 'V' ")
    private String nic;

    @JsonProperty("firstName")
    @NotNull
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private GenderType gender;

    @JsonProperty("maritalStatus")
    @NotNull
    private maritalStatusType maritalStatus;

    @NotNull
    @Email(message = "Please enter a valid email")
    private String email;

    @JsonProperty("phoneNumber")
    @NotNull
    @Pattern(regexp = "^(\\+|0)\\d{9,12}$",message ="Please enter [ (10 Digits) or (+ and country number) ]")
    private String phoneNumber;

    @NotNull
    private Date dob;

    @NotNull
    private String occupation;

    @NotNull
    private Double salary;

    @NotNull
    private Boolean diseased;

    @JsonProperty("familyEntity")
    private Family family;

    @JsonProperty("isActive")
    private IsActiveType isActive;


}
