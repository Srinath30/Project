package com.ecommerce.dao;


import com.ecommerce.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);

    Customer getCustomerByUserName(String userName);

}
