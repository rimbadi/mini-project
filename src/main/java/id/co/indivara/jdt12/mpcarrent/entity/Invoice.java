package id.co.indivara.jdt12.mpcarrent.entity;

import lombok.*;


import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Invoice {
    private Long id;
    private String invoiceId;
    private String rentId;
    private Double carCost;
    private Double driverCost;
    private Double fineCost;
}
