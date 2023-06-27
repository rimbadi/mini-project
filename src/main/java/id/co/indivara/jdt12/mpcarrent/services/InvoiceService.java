package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Invoice;
import id.co.indivara.jdt12.mpcarrent.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public List<Invoice> findAll(){
        return invoiceRepository.findAll();
    }
    public Invoice findByInvoiceId(String invoiceId) {
        Invoice invoice= invoiceRepository.findById(invoiceId).get();
        return invoice;
    }
}
