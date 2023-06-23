package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle, String vehicleId){
        Vehicle vehicleDB = vehicleRepository.findById(vehicleId).get();
        if (Objects.nonNull(vehicle.getVehicleName())&&!"".equalsIgnoreCase(vehicle.getVehicleName())){
            vehicleDB.setVehicleName(vehicle.getVehicleName());
        }
        if (Objects.nonNull(vehicle.getVehicleBrand())&&!"".equalsIgnoreCase(vehicle.getVehicleBrand())){
            vehicleDB.setVehicleBrand(vehicle.getVehicleBrand());
        }
        if (Objects.nonNull(vehicle.getVehiclePrice())){
            vehicleDB.setVehiclePrice(vehicle.getVehiclePrice());
        }
        return vehicleRepository.save(vehicleDB);
    }

    
    public List<Vehicle> fetchAllVehicle() {
        return vehicleRepository.findAll();
    }

    
    public void deleteByIdVehicle(String id) {
        vehicleRepository.deleteById(id);
    }
}
