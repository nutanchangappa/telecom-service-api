package com.springbootproject.telecomserviceapi.service;

import com.springbootproject.telecomserviceapi.model.Customer;
import com.springbootproject.telecomserviceapi.model.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PhoneNumberService {
    List<PhoneNumber> findByCustomer(Customer customer);
    Optional<PhoneNumber> findById(Integer number);
    List<PhoneNumber> findAll();
    void save(PhoneNumber phoneNumber);
}

