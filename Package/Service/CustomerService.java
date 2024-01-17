package com.moviebs.service;
import com.moviebs.model.*;

public interface CustomerService 
{
	//save customer
	Customer saveCustomer(Customer customer);
	
	//check if the customer is present or not
	Integer isCustomerPresent(Customer customer);
}
