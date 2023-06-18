package id.co.indivara.jdt12.mpcarrent.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Vehicle {
    private String vehicleId;
    private String vehicleName;
    private String vehicleBrand;
    private Double vehiclePrice;
}
