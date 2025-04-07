package edu.e_g.dto;

import edu.e_g.util.OfferType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Offers {
    private Long offerId;
    private OfferType offerType;
    private String description;
    private Double amount;
}
