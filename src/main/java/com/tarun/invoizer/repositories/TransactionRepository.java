package com.tarun.invoizer.repositories;

import com.tarun.invoizer.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Page<Transaction> findByInvoiceIdAndUserId(Long invoiceId, Long userId, Pageable pageable);

}
