package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.PayeeClient;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Payee;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PayeeClient payeeClient;

    public void checkAndUsePayee(String customerId) {
        List<Payee> payees = payeeClient.getPayeesByCustomer(customerId);
        payees.forEach(p -> System.out.println(p.getPayeeName()));
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomer(String id) {
        return customerRepository.findById(id);
    }
}
