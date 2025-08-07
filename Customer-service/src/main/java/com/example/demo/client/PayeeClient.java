package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.Payee;

@FeignClient(name = "Online-Banking-Payee-Management", url = "http://localhost:8082") // Use 'name' only if using Eureka
public interface PayeeClient {

    @GetMapping("/api/payees/customer/{customerId}/payees")
    List<Payee> getPayeesByCustomer(@PathVariable("customerId") String customerId);

    @GetMapping("/api/payees/id/{payeeId}")
    Payee getPayeeById(@PathVariable("payeeId") Long payeeId);
}