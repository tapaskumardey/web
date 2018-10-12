package com.oracle.service.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.service.bean.Customer;
import com.oracle.service.dao.CustomerDAO;
import com.oracle.service.exception.CustomerNotFoundException;


@RestController
public class CustomerServiceController {
	protected CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceController(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
    @RequestMapping(value = "/rest/customers", method = RequestMethod.GET)
    public Collection<Customer> getCustomers(){
    	List<Customer> customerList = customerDAO.findAll();
        return customerList;
    }
    
    @RequestMapping("/rest/customers/{customerID}")
	public Customer byNumber(@PathVariable("customerID") Long customerID) {
    	Customer customer = customerDAO.findByCustomerID(customerID);
    	if (customer == null)
			throw new CustomerNotFoundException(customerID);
		else {
			return customer;
		}
	}
}