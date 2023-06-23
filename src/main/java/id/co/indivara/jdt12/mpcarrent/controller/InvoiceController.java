package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Invoice;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping("/invoice")
    public List<Invoice> fetchAllRent(){
        return invoiceService.findAll();
    }
}
