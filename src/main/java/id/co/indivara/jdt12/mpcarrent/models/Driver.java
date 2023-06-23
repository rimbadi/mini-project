package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "mst_drivers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Driver extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "driver_id", updatable = false, nullable = false)
    private String driverId;
    @Column(name = "driver_name",length = 25,nullable = false)
    private String driverName;
    @Column(name ="address",nullable = false)
    private String address;
    @Column(name = "phone_number",length = 13,nullable = false)
    private String phoneNumber;
    @Column(name = "driver_price",length = 10, nullable = false)
    private BigDecimal driverPrice;

}