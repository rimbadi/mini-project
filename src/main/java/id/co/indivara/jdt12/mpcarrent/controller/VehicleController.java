package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) throws Exception{
        return vehicleService.saveVehicle(vehicle);
    }
    @PutMapping("/vehicle/{vehicleId}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable String vehicleId) throws Exception{
        return vehicleService.updateVehicle(vehicle,vehicleId);
    }
    @GetMapping("/vehicle")
    public List<Vehicle> fetchAllVehicle(){
        return vehicleService.fetchAllVehicle();
    }
    @DeleteMapping("/vehicle/{vehicleId}")
    public String deleteVehicle(@PathVariable String vehicleId)throws Exception{
        vehicleService.deleteByIdVehicle(vehicleId);
        return "Delete Success";
    }
    @GetMapping("/vehicle/{vehicleId}")
    public Vehicle findByVehicleId(@PathVariable String vehicleId){
        return vehicleService.findByVehicleId(vehicleId);
    }
}
