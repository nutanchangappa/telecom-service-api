package com.springbootproject.telecomserviceapi.service.impl;

import com.springbootproject.telecomserviceapi.model.Customer;
import com.springbootproject.telecomserviceapi.repository.CustomerRepository;
import com.springbootproject.telecomserviceapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }
}

