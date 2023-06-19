package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/driver")
    public Driver saveDriver(@RequestBody Driver driver){
        return driverService.saveDriver(driver);
    }
    @PutMapping("/driver/{id}")
    public Driver updateDriver(@RequestBody Driver driver,@PathVariable Long id) throws Exception{
        return driverService.updateDriver(driver,id);
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
