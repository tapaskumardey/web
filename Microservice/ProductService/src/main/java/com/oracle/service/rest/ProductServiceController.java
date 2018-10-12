package com.oracle.service.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.service.bean.Product;
import com.oracle.service.dao.ProductDAO;
import com.oracle.service.exception.ProductNotFoundException;


@RestController
public class ProductServiceController {
	protected ProductDAO productDAO;
	
	@Autowired
	public ProductServiceController(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
    @RequestMapping(value = "/rest/products", method = RequestMethod.GET)
    public Collection<Product> getProducts(){
    	List<Product> productList = productDAO.findAll();
        return productList;
    }
    
    @RequestMapping("/rest/products/{customerID}")
	public Product findByProductID(@PathVariable("productID") Long productID) {
    	Product product = productDAO.findByProductID(productID);
    	if (product == null)
			throw new ProductNotFoundException(productID);
		else {
			return product;
		}
	}
}