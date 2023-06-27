package id.co.indivara.jdt12.mpcarrent.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "trx_rents")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Rent extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "rent_id",updatable = false,nullable = false)
    private String rentId;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name ="driver_id")
    private String driverId;
    @Column(name = "vehicle_id")
    private String vehicleId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "driver_id",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_id",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Vehicle vehicle;

    @Column(name = "start_hour",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant startHour;

    @Column(name = "actual_end_hour")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant actualEndHour;

    @Column(name = "rent_status",nullable = false)
    private RentStatus rentStatus;


    public enum RentStatus {
        BOOKED,
        ON_GOING,
        RETURNED
    }
}
