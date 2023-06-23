package id.co.indivara.jdt12.mpcarrent.models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
@Getter @Setter
public class CreateInvoiceDto {
    private String rentId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant startHour;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant plannedEndHour;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant actualEndHour;
    private BigDecimal vehicleCost;
    private BigDecimal driverCost;
    private BigDecimal initialCost;
    private BigDecimal totalCost;
    private Rent.RentStatus rentStatus;
}
