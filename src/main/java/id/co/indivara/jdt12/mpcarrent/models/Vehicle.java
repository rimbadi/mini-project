package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mst_vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Vehicle extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id", updatable = false, nullable = false)
    private Long vehicleId;
    @Column(name = "vehicle_name",length = 25,nullable = false)
    private String vehicleName;
    @Column(name = "vehicle_brand",length = 25,nullable = false)
    private String vehicleBrand;
    @Column(name = "vehicle_price",length = 20,nullable = false)
    private BigDecimal vehiclePrice;
    @Column(name = "vehicle_status")
    private VehicleStatus vehicleStatus;
    public enum VehicleStatus {
        BOOKED,
        AVAILABLE
    }

}
