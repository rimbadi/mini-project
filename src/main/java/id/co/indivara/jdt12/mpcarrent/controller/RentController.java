package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.DTO.RentalDtoReq;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.services.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;
    @PostMapping("/rent")
    public Rent saveRent(@RequestBody RentalDtoReq rent){
        return rentService.saveRent(rent);
    }
    @PutMapping("/rent/{id}")
    public Rent updateRent(@RequestBody Rent rent, @PathVariable Long id){
        return rentService.updateRent(rent, id);
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
