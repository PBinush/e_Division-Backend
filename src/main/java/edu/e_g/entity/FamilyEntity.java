package edu.e_g.entity;

import edu.e_g.util.IncomeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
}
