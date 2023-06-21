package id.co.indivara.jdt12.mpcarrent.models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.Instant;

@Getter
@Setter
public class RentalDtoReq {
    //customer
    private Long customerId;
//    private String customerName;
//    private String customerEmail;
//    private Integer customerKtpNumber;
//    private String customerAddress;
//    private String customerPhoneNumber;

    //driver
    private Long driverId;
    private String driverName;

    //vehicle
    private Long vehicleId;
    private String vehicleName;

    //rent
    private Instant startHour;
    private Instant plannedEndHour;
    private Instant actualEndHour;
    private RentStatus rentStatus;


    public enum RentStatus {
        RENTED,
        RETURNED
    }
}
