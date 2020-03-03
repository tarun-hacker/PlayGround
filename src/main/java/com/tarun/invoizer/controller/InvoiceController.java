package com.tarun.invoizer.controller;

import com.tarun.invoizer.exceptions.ResourceNotFoundException;
import com.tarun.invoizer.models.Invoice;
import com.tarun.invoizer.models.Transaction;
import com.tarun.invoizer.models.User;
import com.tarun.invoizer.security.CustomUserDetail;
import com.tarun.invoizer.services.interfaces.InvoiceService;
import com.tarun.invoizer.services.interfaces.TransactionService;
import com.tarun.invoizer.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController extends BaseController{
    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    private Page<Invoice> getInvoiceForUser(Pageable pageable, Authentication authentication) {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        return invoiceService.getAllInvoices(userDetail.getId(), pageable);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER')")
    private ResponseEntity addInvoice(@Valid @RequestBody Invoice invoice, Authentication authentication) throws ResourceNotFoundException {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        User user = userService.getById(userDetail.getId());
        invoice.setUser(user);
        return ResponseEntity.ok(invoice);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('USER')")
    private ResponseEntity updateInvoice(@Valid @RequestBody Invoice invoice, Authentication authentication) throws ResourceNotFoundException {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        User user = userService.getById(userDetail.getId());
        invoice.setUser(user);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    private ResponseEntity getInvoice(@PathVariable("id") Long id, Authentication authentication) {
        Invoice invoice = invoiceService.getInvoice(id).orElseGet(Invoice::new);
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        if (!invoice.getId().equals(userDetail.getId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid resource access attempt blocked");
        }
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/{id}/transactions")
    @PreAuthorize("hasRole('USER')")
    private Page<Transaction> getTransactions(@PathVariable("id") Long id, Authentication authentication, Pageable pageable) {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        return transactionService.getAllTransaactions(id, userDetail.getId(), pageable);
    }

    @PostMapping("/{id}/transactions")
    @PreAuthorize("hasRole('USER')")
    private ResponseEntity addTransaction(@PathVariable("id") Long id, @RequestBody Transaction transaction, Authentication authentication) throws ResourceNotFoundException {
        System.out.println("A Test"+id);
        System.out.println("A Service"+invoiceService);
        Invoice invoice = invoiceService.getInvoice(id).orElseThrow(ResourceNotFoundException::new);

        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        if (!invoice.getUser().getId().equals(userDetail.getId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid resource access attempt blocked");
        }
        User user = userService.getById(userDetail.getId());
        transaction.setUser(user);
        transaction.setInvoice(invoice);
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @PutMapping("/{id}/transactions")
    @PreAuthorize("hasRole('ADMIN')")
    private ResponseEntity updateTransaction(@PathVariable("id") Long id, @Valid @RequestBody Transaction transaction, Authentication authentication) throws ResourceNotFoundException {
        Invoice invoice = invoiceService.getInvoice(id).orElseThrow(ResourceNotFoundException::new);
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        if (!invoice.getUser().getId().equals(userDetail.getId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid resource access attempt blocked");
        }
        User user = userService.getById(userDetail.getId());
        transaction.setUser(user);
        transaction.setInvoice(invoice);
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }
}
