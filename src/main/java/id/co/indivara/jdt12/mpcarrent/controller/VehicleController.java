package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle saveVehicle(@Valid @RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }
    @PutMapping("/vehicle/{vehicleId}")
    public Vehicle updateVehicle(@Valid @RequestBody Vehicle vehicle, @Valid @PathVariable String vehicleId) throws Exception{
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
