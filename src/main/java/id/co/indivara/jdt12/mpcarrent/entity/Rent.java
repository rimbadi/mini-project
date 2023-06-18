package id.co.indivara.jdt12.mpcarrent.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Rent {
    private Long id;
    private String rentId;
    private String customerId;
    private String vehicleId;
    private String driverId;
    private String checkIn;
    private String checkOuut;
    private Boolean status;
}
