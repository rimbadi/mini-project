package id.co.indivara.jdt12.mpcarrent.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Customer {
    private String customerId;
    private String userName;
    private String email;
    private String ktpNumber;
    private String address;
    private String contact;

}
