package com.example.XYZ.repository;

import com.example.XYZ.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(Long id);
}
