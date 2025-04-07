package edu.e_g.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.e_g.util.GenderType;
import edu.e_g.util.IsActiveType;
import edu.e_g.util.maritalStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="person")
public class PersonEntity {
    @Id
    private String nic;
    private String firstName;
    private String lastName;
    private String address;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private maritalStatusType maritalStatus;

    private String email;
    private String phoneNumber;
    private Date dob;
    private String occupation;
    private Double salary;
    private Boolean diseased;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "familyId")
    @JsonBackReference
    private FamilyEntity familyEntity;

    @Enumerated(EnumType.STRING)
    private IsActiveType isActive;
}

