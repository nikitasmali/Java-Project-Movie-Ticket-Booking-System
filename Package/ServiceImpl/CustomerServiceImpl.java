package com.moviebs.serviceimpl;
import com.moviebs.service.*;
import com.moviebs.model.*;
import com.moviebs.repos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	
	//save customer
	public Customer saveCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}

	@Override
	public Integer isCustomerPresent(Customer customer) 
	{
		 Customer customer1 = customerRepository.getCustomerByEmailAndName(customer.getEmail(),customer.getName());
	     return customer1!=null ? customer1.getId(): null ;
	}
}
