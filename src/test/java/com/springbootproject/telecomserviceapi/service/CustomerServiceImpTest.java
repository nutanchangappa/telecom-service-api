package com.springbootproject.telecomserviceapi.service;

import com.springbootproject.telecomserviceapi.TelecomserviceapiApplication;
import com.springbootproject.telecomserviceapi.model.Customer;
import com.springbootproject.telecomserviceapi.model.PhoneNumber;
import com.springbootproject.telecomserviceapi.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = {TelecomserviceapiApplication.class, CustomerServiceImpl.class, })
public class CustomerServiceImpTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Test
    public void testFindById(){
        Optional<Customer> customer = customerService.findById("AVC003");
        Assert.assertTrue("Rocky Balboa".equals(customer.get().getName()));
    }
}
