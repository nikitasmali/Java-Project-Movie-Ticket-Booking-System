package com.moviebs.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebs.model.*;

@Repository

//inherits a set of CRUD (Create, Read, Update, Delete) operations 
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	
	//method to get customer by their email and name 
	public Customer getCustomerByEmailAndName(String email,String name);

}