package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Rent;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RentService {
    //POST ("/rent")
    Rent saveRent(Rent rent);
    List<Rent> fetchAllRent();
    Rent updateRent(Rent rent, Long id);
    Rent deleteRent(Long id);
    List<Rent> fetchRentByRentId(String rentId);
}
