package com.oracle.service.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUCT")
public class Product {
	@Id
	@Column(name = "PRODUCT_ID")
	private Long productID;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
