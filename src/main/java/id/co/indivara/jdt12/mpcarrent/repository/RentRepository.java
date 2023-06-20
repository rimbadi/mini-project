package id.co.indivara.jdt12.mpcarrent.repository;

import id.co.indivara.jdt12.mpcarrent.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
    List<Rent> fetchByRentId(String rentId);
}
