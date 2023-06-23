package id.co.indivara.jdt12.mpcarrent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "trx_invoices")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Invoice extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "invoice_id", updatable = false, nullable = false)
    private String invoiceId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_id",updatable = false,insertable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Rent rent;

    @Column(name = "rent_id")
    private String rentId;
    @Column(name = "driver_cost")
    private BigDecimal driverCost;

    @Column(name = "inital_cost")
    private BigDecimal initialCost;
    @Column(name ="total_cost")
    private BigDecimal totalCost;

}
