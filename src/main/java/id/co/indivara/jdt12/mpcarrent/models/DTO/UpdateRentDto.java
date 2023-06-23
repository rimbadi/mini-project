package id.co.indivara.jdt12.mpcarrent.models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter @Setter
public class UpdateRentDto {
    private String rentId;
    private String customerId;
    private String driverId;
    private String vehicleId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant startHour;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant actualEndHour;
    private Rent.RentStatus rentStatus;
}
