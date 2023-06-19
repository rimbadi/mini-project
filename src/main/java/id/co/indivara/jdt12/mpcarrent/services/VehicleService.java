package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle,Long id) throws Exception;
    List<Vehicle> fetchAllVehicle();

    void deleteByIdVehicle(Long id);
}
