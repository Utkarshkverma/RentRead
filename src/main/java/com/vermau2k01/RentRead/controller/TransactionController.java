package com.vermau2k01.RentRead.controller;

import com.vermau2k01.RentRead.entity.TransactionHistory;
import com.vermau2k01.RentRead.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final ITransactionService transactionService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<TransactionHistory>> getAllTransactions() {
        List<TransactionHistory> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.FOUND);
    }



}
