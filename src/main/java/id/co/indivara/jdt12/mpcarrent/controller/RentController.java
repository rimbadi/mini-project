package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.DTO.CreateInvoiceDto;
import id.co.indivara.jdt12.mpcarrent.models.DTO.CreateRentDto;
import id.co.indivara.jdt12.mpcarrent.models.Invoice;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.services.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@Validated
public class RentController {
    private final RentService rentService;
    @PostMapping("/rent")
    @ResponseStatus(HttpStatus.CREATED)
    public Rent saveRent(@Valid @RequestBody CreateRentDto rent)throws Exception{
        return rentService.saveRent(rent);
    }
    @PutMapping("/rent/{id}")
    public Invoice finishRent(@RequestBody CreateInvoiceDto invoice, @PathVariable String id) throws Exception{
        return rentService.finishRent(invoice, id);
    }

    @GetMapping("/rent")
    public ArrayList<Rent> fetchAllRent(){
       return rentService.fetchAllRent();
    }

    @GetMapping("/rent/{rentId}")
    public Rent findByRentId(@PathVariable String rentId){
        return rentService.findByRentId(rentId);
    }

}
