package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "name",length = 25,nullable = false)
    private String name;

    @Column(name = "email", length = 25,nullable = false)
    private String email;

    @Column(name = "ktp_number",length = 15,nullable = false)
    private Integer ktpNumber;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "phone_number", length = 13,nullable = false)
    private String phoneNumber;

}
