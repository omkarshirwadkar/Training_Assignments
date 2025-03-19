package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Customer;
import com.example.demo.service.CustomerService;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Get all customers
    @GetMapping
    public Iterable<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // Get customer by ID
    @GetMapping("/{cid}")
    public Optional<Customer> getCustomerById(@PathVariable int cid) {
        return customerService.getCustomerById(cid);
    }

    // Insert new customer
    @PostMapping("/insert")
    public String insertCustomer(@RequestBody Customer customer) {
        return customerService.insertCustomer(customer);
    }

    // Update customer balance
    @PutMapping("/updateBalance/{cid}")
    public String updateBalance(@PathVariable int cid, @RequestParam int amount) {
        return customerService.updateBalance(cid, amount);
    }
}
