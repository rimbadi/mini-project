package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/driver")
    @ResponseStatus(HttpStatus.CREATED)
    public Driver saveDriver( @RequestBody Driver driver) throws Exception{
        return driverService.saveDriver(driver);
    }
    @PutMapping("/driver/{driverId}")
    public Driver updateDriver(@RequestBody Driver driver,@PathVariable String driverId) throws Exception{
        return driverService.updateDriver(driver,driverId);
    }
    @GetMapping("/driver")
    public List<Driver> fetchAllDriver(){
        return driverService.fetchAllDriver();
    }
    @DeleteMapping("/driver/{driverId}")
    public String deleteById(@PathVariable String driverId)throws Exception{
        driverService.deleteDriverById(driverId);
        return "Delete berhasil";
    }
    @GetMapping("/driver/{driverId}")
    public Driver findByDriverId(@PathVariable String driverId){
        return driverService.findByDriverId(driverId);
    }
}
