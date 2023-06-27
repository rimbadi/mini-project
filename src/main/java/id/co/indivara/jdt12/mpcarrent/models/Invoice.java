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
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "driver_name")
    private String driverName;
    @Column(name = "vehicle_cost")
    private BigDecimal vehicleCost;
    @Column(name = "driver_cost")
    private BigDecimal driverCost;
    @Column(name = "inital_cost")
    private BigDecimal initialCost;
    @Column(name ="total_cost")
    private BigDecimal totalCost;

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", rent=" + rent +
                ", rentId='" + rentId + '\'' +
                ", Customer name='" + customerName + '\'' +
                ", Driver name='" + driverName + '\'' +
                ", Vehicle cost perhour=" + vehicleCost +
                ", Driver cost perhour=" + driverCost +
                ", Initial cost=" + initialCost +
                ", Total cost=" + totalCost +
                '}';
    }
}
