package com.tarun.invoizer.services.interfaces;

import com.tarun.invoizer.models.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface InvoiceService {
    Invoice addInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    Invoice removeInvoice(Invoice invoice);
    Page<Invoice> getAllInvoices(Long id, Pageable pageable);
    Page<Invoice> getAllInvoices(Pageable pageable);
    Optional<Invoice> getInvoice(Long id);
}
