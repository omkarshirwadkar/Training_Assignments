package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.models.Customer;
import com.example.demo.models.Transactions;
import com.example.demo.repos.CustomerDAO;
import com.example.demo.repos.TransactionsDAO;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionsDAO transactionRepository;

    @Autowired
    private CustomerDAO customerRepository;

    @Transactional
    public String makeTransaction(Transactions transaction) {
        Optional<Customer> senderOpt = customerRepository.findById(transaction.getCustomer().getCid());
        Optional<Customer> receiverOpt = customerRepository.findById(transaction.getToid());

        if (senderOpt.isPresent() && receiverOpt.isPresent()) {
            Customer sender = senderOpt.get();
            Customer receiver = receiverOpt.get();

            if (sender.getBalance() < transaction.getAmount()) {
                return "Insufficient Balance!";
            }

            sender.setBalance(sender.getBalance() - transaction.getAmount());
            receiver.setBalance(receiver.getBalance() + transaction.getAmount());

            customerRepository.save(sender);
            customerRepository.save(receiver);
            transactionRepository.save(transaction);

            return "Transaction Successful!";
        } else {
            return "Invalid Sender or Receiver!";
        }
    }

    public Iterable<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
