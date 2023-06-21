package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "mst_drivers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Driver extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver_id", updatable = false, nullable = false)
    private Long driverId;

    @Column(name = "driver_name",length = 25,nullable = false)
    private String driverName;
    @Column(name = "phone_number",length = 13,nullable = false)
    private String phoneNumber;
    @Column(name ="address",nullable = false)
    private String address;
    @Column(name = "driver_price",length = 10, nullable = false)
    private BigDecimal driverPrice;
    @Column(name = "driver_status")
    private DriverStatus driverStatus;
    public enum DriverStatus {
        BOOKED,
        AVAILABLE
    }
}