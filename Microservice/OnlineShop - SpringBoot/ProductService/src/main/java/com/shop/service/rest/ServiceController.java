package com.shop.service.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.shop.service.bean.Product;

@RestController
@RequestMapping("products")
public class ServiceController {
	private List<Product> productList;

	@Autowired
	public ServiceController() {
		populateProducts();
	}

	@RequestMapping(value = "/{productIDs}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findProducs(@PathVariable("productIDs") List<Long> productIDs) {
		System.out.println(productIDs);
		if(productIDs != null) System.out.println(productIDs.size());
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	private List<Product> populateProducts() {
		productList = new ArrayList<>();
		for (int i = 1; i < 31; i++) {
			Product product = new Product();
			product.setProductID(new Long(i));
			product.setProductName("Product "+i);
			productList.add(product);
		}
		return productList;
	}
}