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
    private Long personId;
    private String name;
    private String address;
    private String nic;
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private maritalStatusType maritalStatus;
    private String email;
    private String phoneNumber;
    private String occupation;
    private Double salary;

    @Enumerated(EnumType.STRING)
    private DiseasedType diseased;
    private Long family;

    @Enumerated(EnumType.STRING)
    private IsActiveType isActive;
}

