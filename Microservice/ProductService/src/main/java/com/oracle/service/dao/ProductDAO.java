package com.oracle.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.oracle.service.bean.Product;

public interface ProductDAO  extends Repository<Product, Long>{
	public Product findByProductID(Long productID);
	
	public List<Product> findAll();
	
	@Query("SELECT count(*) from Product")
	public int countProducts();
}
