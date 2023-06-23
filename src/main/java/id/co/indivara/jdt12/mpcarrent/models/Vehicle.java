package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mst_vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Vehicle extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "vehicle_id", updatable = false, nullable = false)
    private String vehicleId;
    @Column(name = "vehicle_name",length = 25,nullable = false)
    private String vehicleName;
    @Column(name = "vehicle_brand",length = 25,nullable = false)
    private String vehicleBrand;
    @Column(name = "vehicle_price",length = 20,nullable = false)
    private BigDecimal vehiclePrice;
}
