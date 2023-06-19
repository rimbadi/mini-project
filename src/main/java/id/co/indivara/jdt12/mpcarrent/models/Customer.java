package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerId;
    private String name;
    private String email;
    private String ktpNumber;
    private String address;
    private String contact;

}
