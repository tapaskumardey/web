package com.oracle.service.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.oracle.service.bean.Product;
import com.oracle.service.dao.ProductDAO;
import com.oracle.service.exception.ProductNotFoundException;


@RestController
public class ProductServiceController {
	protected ProductDAO productDAO;
	private final RestTemplate restTemplate;
	private static final String CUSTOMER_API_PATH = "http://localhost:7171/rest/customers";
	
	@Autowired
	public ProductServiceController(RestTemplate restTemplate,ProductDAO productDAO) {
		this.restTemplate = restTemplate;
		this.productDAO = productDAO;
	}
	
    @RequestMapping(value = "/rest/products", method = RequestMethod.GET)
    public Collection<Product> getProducts(){
    	List<Product> productList = productDAO.findAll();
        return productList;
    }
    
    @RequestMapping("/rest/products/{productID}")
	public Product findByProductID(@PathVariable("productID") Long productID) {
    	Product product = productDAO.findByProductID(productID);
    	if (product == null)
			throw new ProductNotFoundException(productID);
		else {
			return product;
		}
	}
    
    @RequestMapping(value = "/rest/products/{customerID}/check", method = RequestMethod.GET)
    public String checkProductByValidCustomer(@PathVariable("customerID") Long customerID){
    	try {
			String response = this.restTemplate.getForObject(CUSTOMER_API_PATH + "/{customerID}", String.class,customerID);
			System.out.println("response: "+response);
        	return response;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}