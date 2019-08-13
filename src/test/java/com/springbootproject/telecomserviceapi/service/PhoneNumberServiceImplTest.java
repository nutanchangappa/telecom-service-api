package com.springbootproject.telecomserviceapi.service;

import com.springbootproject.telecomserviceapi.TelecomserviceapiApplication;
import com.springbootproject.telecomserviceapi.model.Customer;
import com.springbootproject.telecomserviceapi.model.PhoneNumber;
import com.springbootproject.telecomserviceapi.service.impl.PhoneNumberServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = {TelecomserviceapiApplication.class, PhoneNumberServiceImpl.class})
public class PhoneNumberServiceImplTest {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Test
    public void testFindByCustomer(){
        Customer customer = new Customer();
        customer.setId("AVC002");
        customer.setName("Mike Tyson");
        List<PhoneNumber> list = phoneNumberService.findByCustomer(customer);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testFindById(){
        Optional<PhoneNumber> number = phoneNumberService.findById(6100001);
        Assert.assertTrue(number.isPresent());
    }

    @Test
    public void testFindAll(){
        List<PhoneNumber> list = phoneNumberService.findAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setId("AVC003");
        customer.setName("Rocky Balboa");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(6100007);
        phoneNumber.setActive(true);
        phoneNumber.setCustomer(customer);
        phoneNumberService.save(phoneNumber);
    }
}
