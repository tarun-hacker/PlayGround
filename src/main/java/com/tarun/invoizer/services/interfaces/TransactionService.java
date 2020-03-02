package com.tarun.invoizer.services.interfaces;

import com.tarun.invoizer.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TransactionService {
    Page<Transaction> getAllTransaactions(Long invoiceId, Long userId, Pageable pageable);
    Optional<Transaction> getTransaction(Long transactionId);
    Transaction saveTransaction(Transaction transaction);
    Transaction removeTransaction(Transaction transaction);
}
