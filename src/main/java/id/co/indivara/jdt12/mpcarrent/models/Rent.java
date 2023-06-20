package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rents")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rentId;
    private String customerId;
    private String vehicleId;
    private String driverId;
    private String checkIn;
    private String checkOut;
    private Boolean status;
}
