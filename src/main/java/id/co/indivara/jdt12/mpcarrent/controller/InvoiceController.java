package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Invoice;
import id.co.indivara.jdt12.mpcarrent.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping("/invoice")
    public List<Invoice> fetchAllRent(){
        return invoiceService.findAll();
    }
    @GetMapping("/invoice/{invoiceId}")
    public Invoice findByinvoiceId(@PathVariable String invoiceId){
        return invoiceService.findByInvoiceId(invoiceId);
    }
}
