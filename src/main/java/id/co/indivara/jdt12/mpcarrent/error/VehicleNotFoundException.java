package id.co.indivara.jdt12.mpcarrent.error;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(Long id){
        super("Vehicle not found: "+id);
    }
}
