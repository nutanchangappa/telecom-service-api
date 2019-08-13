package com.springbootproject.telecomserviceapi.service.impl;

import com.springbootproject.telecomserviceapi.model.Customer;
import com.springbootproject.telecomserviceapi.model.PhoneNumber;
import com.springbootproject.telecomserviceapi.repository.PhoneNumberRepository;
import com.springbootproject.telecomserviceapi.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public List<PhoneNumber> findByCustomer(Customer customer) {
        return phoneNumberRepository.findByCustomer(customer);
    }

    @Override
    public Optional<PhoneNumber> findById(Integer number) {
        return phoneNumberRepository.findById(number);
    }

    @Override
    public List<PhoneNumber> findAll() {
        return phoneNumberRepository.findAll();
    }

    @Transactional
    @Override
    public void save(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }
}


