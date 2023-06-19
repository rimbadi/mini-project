package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vehicles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vehicleId;
    private String vehicleName;
    private String vehicleBrand;
    private Double vehiclePrice;
}
