package edu.e_g.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.e_g.util.IncomeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Family {
    @JsonProperty("familyId")
    private Long familyId;

    @JsonProperty("numberOfMembers")
    private Integer numberOfMembers;

    @JsonProperty("incomeType")
    private IncomeType incomeType;
    private List<Person> personList;
}
