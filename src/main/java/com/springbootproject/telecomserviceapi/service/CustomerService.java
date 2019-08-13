package com.springbootproject.telecomserviceapi.service;

import com.springbootproject.telecomserviceapi.model.Customer;
import com.springbootproject.telecomserviceapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(String id);
}

