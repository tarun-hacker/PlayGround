package com.tarun.invoizer.services.implementations;

import com.tarun.invoizer.models.Invoice;
import com.tarun.invoizer.repositories.InvoiceRepository;
import com.tarun.invoizer.services.interfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice removeInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice);
        return invoice;
    }

    @Override
    public Page<Invoice> getAllInvoices(Long id, Pageable pageable) {
        return invoiceRepository.findByUserId(id,pageable);
    }

    @Override
    public Page<Invoice> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    @Override
    public Optional<Invoice> getInvoice(Long id) {
        return invoiceRepository.findById(id);
    }
}
