package com.example.XYZ.service;

import com.example.XYZ.entity.Customer;

public interface CustomerService {
    Customer save(Customer customer);

    Customer findCustomerById(Long id);
}
