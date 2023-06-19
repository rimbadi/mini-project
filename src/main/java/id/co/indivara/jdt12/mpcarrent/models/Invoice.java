package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;


import javax.persistence.*;

@Entity
@Data
@Table(name = "invoices")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String invoiceId;
    private String rentId;
    private Double carCost;
    private Double driverCost;
    private Double fineCost;
}
