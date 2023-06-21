package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "trx_invoices")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Invoice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mst_invoice_id", updatable = false, nullable = false)
    private Long invoiceId;

    @Column(name = "rent_id",nullable = false)
    private Long rentId;
    @Column(name = "vehicle_cost")
    private BigDecimal vehicleCost;
    @Column(name = "driver_cost")
    private BigDecimal driverCost;
    @Column(name = "fine_cost")
    private BigDecimal fineCost;
    @Column(name = "inital_cost")
    private BigDecimal initialCost;
    @Column(name="total_cost")
    private BigDecimal totalCost;
}
