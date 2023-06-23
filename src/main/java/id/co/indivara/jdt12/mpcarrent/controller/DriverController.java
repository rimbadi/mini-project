package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/driver")
    public Driver saveDriver(@RequestBody Driver driver){
        return driverService.saveDriver(driver);
    }
    @PutMapping("/driver/{driverId}")
    public Driver updateDriver(@RequestBody Driver driver,@PathVariable String driverId){
        return driverService.updateDriver(driver,driverId);
    }
    @GetMapping("/driver")
    public List<Driver> fetchAllDriver(){
        return driverService.fetchAllDriver();
    }
    @DeleteMapping("/driver/{driverId}")
    public String deleteById(@PathVariable String driverId){
        driverService.deleteDriverById(driverId);
        return "Delete berhasil";
    }
}
