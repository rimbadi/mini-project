package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    
    public Vehicle updateVehicle(Vehicle vehicle, Long id) throws Exception {
        Vehicle vehicleDB=vehicleRepository.findById(id).orElseThrow(Exception::new);
        vehicleDB.setVehicleId(vehicle.getVehicleId());
        vehicleDB.setVehicleName(vehicle.getVehicleName());
        vehicleDB.setVehicleBrand(vehicle.getVehicleBrand());
        vehicleDB.setVehiclePrice(vehicle.getVehiclePrice());
        return vehicleRepository.save(vehicleDB);
    }

    
    public List<Vehicle> fetchAllVehicle() {
        return vehicleRepository.findAll();
    }

    
    public void deleteByIdVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
