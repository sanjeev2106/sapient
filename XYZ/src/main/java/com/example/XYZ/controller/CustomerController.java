package com.example.XYZ.controller;

import com.example.XYZ.entity.Customer;
import com.example.XYZ.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }
}
