package edu.e_g.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.e_g.util.IncomeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "family")
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyId;
    private Integer numberOfMembers;

    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;

//    @OneToMany(mappedBy = "familyEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JsonManagedReference
//    private List<PersonEntity> personList;
}
