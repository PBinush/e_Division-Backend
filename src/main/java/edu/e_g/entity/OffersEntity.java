package edu.e_g.entity;

import edu.e_g.util.OfferType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="allowances")
public class OffersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    private String description;
    private Double amount;
}
