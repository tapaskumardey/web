package com.oracle.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.oracle.service.bean.Customer;

public interface CustomerDAO  extends Repository<Customer, Long>{
	public Customer findByCustomerID(Long customerID);
	
	//@Query("SELECT * from Customer")
	public List<Customer> findAll();
	
	@Query("SELECT count(*) from Customer")
	public int countCustomers();
}
