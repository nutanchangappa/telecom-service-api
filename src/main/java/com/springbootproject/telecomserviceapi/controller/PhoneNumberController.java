package com.springbootproject.telecomserviceapi.controller;


import com.springbootproject.telecomserviceapi.model.Customer;
import com.springbootproject.telecomserviceapi.model.PhoneNumber;
import com.springbootproject.telecomserviceapi.service.CustomerService;
import com.springbootproject.telecomserviceapi.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service")
public class PhoneNumberController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PhoneNumberService phoneNumberService;


    /*
        Get all phone numbers
    */
    @GetMapping("/phonenumbers")
    public List<PhoneNumber> getAllPhoneNumbers() {
        List<PhoneNumber> phoneNumbers = phoneNumberService.findAll();
        return phoneNumbers;
    }

    /*
    Get all phone numbers of a single customer
    */
    @GetMapping("/customers/{id}/phonenumbers")
    public List<PhoneNumber> getPhoneNumbersByCustomer(@PathVariable(value = "id") String customerId)
            throws Exception {
        Optional<Customer> customer = customerService.findById(customerId);
        if (!customer.isPresent()) {
            throw new Exception("Customer not found [ " + customerId + " ]");
        }
        return phoneNumberService.findByCustomer(customer.get());
    }


    /*
    Activate a phone number for a subscriber
     */
    @PutMapping("/phonenumbers/{number}/activation")
    public ResponseEntity<?> activatePhoneNumber(@PathVariable(value = "number") Integer number) throws Exception {
        Optional<PhoneNumber> phoneNumberOptional = phoneNumberService.findById(number);
        if (!phoneNumberOptional.isPresent()) {
            throw new Exception("Phone Number not found [ " + number + " ]");
        }
        PhoneNumber phoneNumber = phoneNumberOptional.get();
        phoneNumber.setActive(true);
        phoneNumberService.save(phoneNumber);
        return ResponseEntity.ok().build();
    }

    /*
   Get one phonenumber
   */
    @GetMapping("/phonenumbers/{number}")
    public PhoneNumber getPhoneNumber(@PathVariable(value = "number") Integer number) throws Exception {
        Optional<PhoneNumber> phoneNumber = phoneNumberService.findById(number);
        if (!phoneNumber.isPresent()) {
            throw new Exception("Phone number not found [ " + number + " ]");
        }
        return phoneNumber.get();
    }


}

