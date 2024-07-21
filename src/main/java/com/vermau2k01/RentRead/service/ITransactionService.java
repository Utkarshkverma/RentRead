package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.entity.TransactionHistory;

import java.util.List;

public interface ITransactionService {

    List<TransactionHistory> getAllTransactions();
    void deletePreviousTransactions();
}
