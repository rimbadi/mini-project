package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }
    @PutMapping("/vehicle/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id)throws Exception{
        return vehicleService.updateVehicle(vehicle,id);
    }
    @GetMapping("/vehicle")
    public List<Vehicle> fetchAllVehicle(){
        return vehicleService.fetchAllVehicle();
    }
    @DeleteMapping("/vehicle/{id}")
    public String deleteVehicle(@PathVariable Long id){
        vehicleService.deleteByIdVehicle(id);
        return "Delete Success";
    }
}
