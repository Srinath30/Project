package com.ecommerce.service;

import com.ecommerce.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);

	Customer getCustomerByUserName(String userName);
}
