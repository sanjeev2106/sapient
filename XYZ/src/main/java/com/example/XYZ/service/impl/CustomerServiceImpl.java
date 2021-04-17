package com.example.XYZ.service.impl;

import com.example.XYZ.entity.Customer;
import com.example.XYZ.repository.CustomerRepository;
import com.example.XYZ.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }
}
