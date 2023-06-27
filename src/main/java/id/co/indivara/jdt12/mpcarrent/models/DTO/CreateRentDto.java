package id.co.indivara.jdt12.mpcarrent.models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Getter @Setter
@ToString
public class CreateRentDto {
    private String customerId;
    private String driverId;
    private String vehicleId;

    private BigDecimal vehicleCost;
    private BigDecimal driverCost;
    private BigDecimal initialCost;
    private BigDecimal totalCost;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant startHour;

}
