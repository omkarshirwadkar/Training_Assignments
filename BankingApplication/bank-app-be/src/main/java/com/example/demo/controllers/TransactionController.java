package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Transactions;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    // Make a transaction
    @PostMapping("/make")
    public String makeTransaction(@RequestBody Transactions transaction) {
        return transactionService.makeTransaction(transaction);
    }

    // Get all transactions
    @GetMapping
    public Iterable<Transactions> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
