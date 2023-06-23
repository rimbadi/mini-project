package id.co.indivara.jdt12.mpcarrent.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "mst_customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "name",length = 25,nullable = false)
    private String name;

    @Column(name = "email", length = 25,nullable = false)
    private String email;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "ktp_number",length = 15,nullable = false)
    private String ktpNumber;

    @Column(name = "phone_number", length = 13,nullable = false)
    private String phoneNumber;

}
