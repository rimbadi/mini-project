package id.co.indivara.jdt12.mpcarrent.implement;

import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.repository.RentRepository;
import id.co.indivara.jdt12.mpcarrent.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentImpl implements RentService {
    @Autowired
    RentRepository rentRepository;
    @Override
    public Rent saveRent(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public Rent updateRent(Rent rent, Long rentId) {
        Rent rentDB = rentRepository.findById(rentId).get();
        rentDB.setRentId(rent.getRentId());
        rentDB.setCustomerId(rent.getCustomerId());
        rentDB.setDriverId(rent.getDriverId());
        rentDB.setVehicleId(rent.getVehicleId());
        rentDB.setCheckIn(rent.getCheckIn());
        rentDB.setCheckIn(rent.getCheckIn());
        rentDB.setCheckOut(rent.getCheckOut());
        rentDB.setStatus(rent.getStatus());
        return rentRepository.save(rentDB);
    }

    @Override
    public List<Rent> fetchAllRent() {
        return rentRepository.findAll();
    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.deleteById(id);

    }

    @Override
    public List<Rent> findByRentId(String rentId) {
        ArrayList<Rent> rents= (ArrayList<Rent>) rentRepository.findByRentId(rentId);
        return rents;
    }
}
