package com.tarun.invoizer.controller;

import com.tarun.invoizer.services.interfaces.InvoiceService;
import com.tarun.invoizer.services.interfaces.ProductService;
import com.tarun.invoizer.services.interfaces.TransactionService;
import com.tarun.invoizer.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@RestController
public class BaseController {
    @Autowired
    protected InvoiceService invoiceService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected TransactionService transactionService;

    @Autowired
    protected ProductService productService;

}
