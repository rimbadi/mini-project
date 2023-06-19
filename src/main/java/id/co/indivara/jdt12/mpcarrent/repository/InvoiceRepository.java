package id.co.indivara.jdt12.mpcarrent.repository;

import id.co.indivara.jdt12.mpcarrent.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
