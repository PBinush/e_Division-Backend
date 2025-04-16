package edu.e_g.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.e_g.util.DiseasedType;
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

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    @JsonProperty("personId")
    private Long personId;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @Pattern(regexp = "^\\d{9,10}[Vv]?$" ,message = "Please give 10 Digits or 'V' ")
    private String nic;

    @NotNull
    private LocalDate dob;

    @NotNull
    private GenderType gender;

    @JsonProperty("maritalStatus")
    @NotNull
    private maritalStatusType maritalStatus;

    @Email(message = "Please enter a valid email")
    private String email;

    @JsonProperty("phoneNumber")
    @Pattern(regexp = "^(\\+|0)\\d{9,12}$",message ="Please enter [ (10 Digits) or (+ and country number) ]")
    private String phoneNumber;

    @NotNull
    private String occupation;

    @NotNull
    private Double salary;

    @NotNull
    private DiseasedType diseased;

    private Long family;

    @JsonProperty("isActive")
    private IsActiveType isActive;
}
