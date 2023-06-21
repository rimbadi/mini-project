package id.co.indivara.jdt12.mpcarrent.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Column(nullable = false)
    private Date createDateTime;
    @Column(nullable = false)
    private Date updateDateTime;

    @PrePersist
    private void onCreate() {
        this.createDateTime = new Date();
        this.updateDateTime = this.createDateTime;
    }

    @PreUpdate
    private void onUpdate() {
        this.updateDateTime = new Date();
    }
}
