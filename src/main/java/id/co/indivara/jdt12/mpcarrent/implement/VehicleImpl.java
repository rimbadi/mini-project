package id.co.indivara.jdt12.mpcarrent.implement;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.repository.VehicleRepository;
import id.co.indivara.jdt12.mpcarrent.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, Long id) throws Exception {
        Vehicle vehicleDB=vehicleRepository.findById(id).orElseThrow(()-> new Exception());
        vehicleDB.setVehicleId(vehicle.getVehicleId());
        vehicleDB.setVehicleName(vehicle.getVehicleName());
        vehicleDB.setVehicleBrand(vehicle.getVehicleBrand());
        vehicleDB.setVehiclePrice(vehicle.getVehiclePrice());
        return vehicleRepository.save(vehicleDB);
    }

    @Override
    public List<Vehicle> fetchAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public void deleteByIdVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
