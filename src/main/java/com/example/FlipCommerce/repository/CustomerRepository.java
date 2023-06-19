package com.example.FlipCommerce.repository;

import com.example.FlipCommerce.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmailId(String customerEmailId);
}
