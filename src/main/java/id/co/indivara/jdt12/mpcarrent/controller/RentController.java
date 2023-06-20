package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentController {
    @Autowired
    RentService rentService;
    @PostMapping("/rent")
    public Rent saveRent(@RequestBody Rent rent){
        return rentService.saveRent(rent);
    }
    @PutMapping("/rent/{id}")
    public Rent updateRent(@RequestBody Rent rent, @PathVariable Long id){
        return rentService.updateRent(rent, id);
    }
    @DeleteMapping("/rent/{id}")
    public String deleteRent(@PathVariable Long id){
        rentService.deleteRent(id);
        return "Delete Berhasil";
    }
    @GetMapping("/rent")
    public List<Rent> fetchAllRent(){
       return rentService.fetchAllRent();
    }
    @GetMapping("/rent/{rentId}")
    public List<Rent> findByRentId(@PathVariable String rentId){
        return rentService.findByRentId(rentId);
    }
}
