package com.tarun.invoizer.services.implementations;

import com.tarun.invoizer.models.Transaction;
import com.tarun.invoizer.repositories.TransactionRepository;
import com.tarun.invoizer.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Page<Transaction> getAllTransaactions(Long invoiceId, Long userId, Pageable pageable) {
        return transactionRepository.findByInvoiceIdAndUserId(invoiceId,userId,pageable);
    }

    @Override
    public Optional<Transaction> getTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction removeTransaction(Transaction transaction) {
        transactionRepository.delete(transaction);
        return transaction;
    }
}
