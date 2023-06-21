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
    @PutMapping("/driver/{id}")
    public Driver updateDriver(@RequestBody Driver driver,@PathVariable Long driverId) throws Exception{
        return driverService.updateDriver(driver,driverId);
    }
    @GetMapping("/driver")
    public List<Driver> fetchAllDriver(){
        return driverService.fetchAllDriver();
    }
    @DeleteMapping("/driver/{id}")
    public String deleteById(@PathVariable Long id){
        driverService.deleteDriverById(id);
        return "Delete berhasil";
    }
}
