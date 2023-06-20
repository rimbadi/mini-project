package id.co.indivara.jdt12.mpcarrent.repository;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
