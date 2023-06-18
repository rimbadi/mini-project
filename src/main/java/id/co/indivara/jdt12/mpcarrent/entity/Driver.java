package id.co.indivara.jdt12.mpcarrent.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Driver {
    private String driverId;
    private String driverName;
    private String contact;
    private String address;
    private Double driverPrice;
}