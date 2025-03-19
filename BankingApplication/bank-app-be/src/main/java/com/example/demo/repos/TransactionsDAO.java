package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Transactions;

public interface TransactionsDAO extends JpaRepository<Transactions, Integer>{

}
