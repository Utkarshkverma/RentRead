package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.entity.TransactionHistory;
import com.vermau2k01.RentRead.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;


    @Override
    public List<TransactionHistory> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Scheduled(cron = "0 0 0 1 * *")
    @Override
    public void deletePreviousTransactions() {

        LocalDate deletingDate = LocalDate.now().minusMonths(1);
        transactionRepository.deleteOneMonthBackTransaction(deletingDate);
    }
}
