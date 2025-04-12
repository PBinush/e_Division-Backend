package edu.e_g.entity;

import edu.e_g.util.DiseasedType;
import edu.e_g.util.GenderType;
import edu.e_g.util.IsActiveType;
import edu.e_g.util.maritalStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="person")
public class PersonEntity {
    private String name;
    private String address;
    private String nic;
    private LocalDate dob;
    private GenderType gender;
    private maritalStatusType maritalStatus;
    private String email;
    private String phoneNumber;
    private String occupation;
    private Double salary;
    private DiseasedType diseased;
//    private FamilyEntity family;
    private IsActiveType isActive;
}

