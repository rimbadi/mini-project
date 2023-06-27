package id.co.indivara.jdt12.mpcarrent.repository;

import id.co.indivara.jdt12.mpcarrent.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,String> {
    boolean existsByPhoneNumber();
}
