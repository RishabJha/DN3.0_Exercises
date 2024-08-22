package com.example.BookStoreAPI.controller;

import com.example.BookStoreAPI.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private List<Customer> customerList = new ArrayList<>();

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customerList.add(customer);
        return customer;
    }

    @PostMapping("/form")
    public Customer createCustomerWithFormData(@RequestParam Long id, @RequestParam String name, @RequestParam String email, @RequestParam String phoneNumber) {
        Customer customer = new Customer(id, name, email, phoneNumber);
        return customer;
    }
}
