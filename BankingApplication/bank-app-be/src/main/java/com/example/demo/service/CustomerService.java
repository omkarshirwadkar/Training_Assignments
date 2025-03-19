package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Customer;
import com.example.demo.repos.CustomerDAO;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerRepository;

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int cid) {
        return customerRepository.findById(cid);
    }

    public String insertCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer inserted successfully!";
    }

    public String updateBalance(int cid, int amount) {
        Optional<Customer> customerOpt = customerRepository.findById(cid);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setBalance(customer.getBalance() + amount);
            customerRepository.save(customer);
            return "Balance updated successfully!";
        }
        return "Customer not found!";
    }
}
