package id.co.indivara.jdt12.mpcarrent.error;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(Vehicle vehicle){
        super("Vehicle not found: "+vehicle);
    }
}
