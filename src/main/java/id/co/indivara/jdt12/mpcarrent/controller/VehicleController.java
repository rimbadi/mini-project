package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/vehicle")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }
    @PutMapping("/vehicle/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable String vehicleId) throws Exception{
        return vehicleService.updateVehicle(vehicle,vehicleId);
    }
    @GetMapping("/vehicle")
    public List<Vehicle> fetchAllVehicle(){
        return vehicleService.fetchAllVehicle();
    }
    @DeleteMapping("/vehicle/{id}")
    public String deleteVehicle(@PathVariable String id)throws Exception{
        vehicleService.deleteByIdVehicle(id);
        return "Delete Success";
    }
}
