package com.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;
import com.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {   	 
   	 customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
   	 return customerDao.getCustomerByUserName(userName);
    }
}
