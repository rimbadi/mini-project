package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Rent;

import java.util.List;

public interface RentService {
    //POST ("/rent")
    Rent saveRent(Rent rent);
    List<Rent> fetchAllRent();
    Rent updateRent(Rent rent, Long id);
    void deleteRent(Long id);
    List<Rent> findByRentId(String rentId);
}
