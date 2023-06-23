package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.DTO.CreateInvoiceDto;
import id.co.indivara.jdt12.mpcarrent.models.DTO.CreateRentDto;
import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.models.Invoice;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final RentRepository rentRepository;



    public List<Invoice> findAll(){
       return invoiceRepository.findAll();
    }
    public Invoice findByRentId(@Param("rentId") String rentId){
        return invoiceRepository.findById(rentId).get();
    }

}
