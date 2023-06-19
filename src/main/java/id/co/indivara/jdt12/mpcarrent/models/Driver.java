package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drivers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String driverId;
    private String driverName;
    private String contact;
    private String address;
    private Double driverPrice;
}