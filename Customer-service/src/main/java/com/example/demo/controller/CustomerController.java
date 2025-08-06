package com.example.demo.controller;

import com.example.demo.client.PayeeClient;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Payee;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private PayeeClient payeeClient;

    @GetMapping("/my-payees/{customerId}")
    public ResponseEntity<List<Payee>> getMyPayees(@PathVariable String customerId) {
        List<Payee> payees = payeeClient.getPayeesByCustomer(customerId);
        return ResponseEntity.ok(payees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerRepo.save(customer));
    }
}
