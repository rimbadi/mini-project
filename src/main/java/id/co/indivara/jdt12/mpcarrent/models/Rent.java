package id.co.indivara.jdt12.mpcarrent.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "trx_rents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Rent extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rent_id",updatable = false,nullable = false)
    private Long rentId;

    @Column(name = "customer_id",nullable = false)
    private Long customerId;

    @Column(name = "vehicle_id",nullable = false)
    private Long vehicleId;

    @Column(name = "driver_id",nullable = false)
    private Long driverId;

    @Column(name = "start_hour",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant startHour;

    @Column(name = "planned_end_hour",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant plannedEndHour;

    @Column(name = "actual_end_hour")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant actualEndHour;

    @Column(name = "rent_status",nullable = false)
    private RentStatus rentStatus;


    public enum RentStatus {
        RENTED,
        ON_GOING,
        RETURNED
    }
}
