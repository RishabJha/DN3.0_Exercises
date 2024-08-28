package com.example.BookStoreAPI.repository;

import com.example.BookStoreAPI.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
