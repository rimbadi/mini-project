package id.co.indivara.jdt12.mpcarrent.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@Getter @Setter
public class Customer {
    private Long id;
    private String customerId;
    private String customerName;
    private String customerAddress;


}
