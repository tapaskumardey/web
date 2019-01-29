package com.shop.service.order.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shop.service.order.bean.Order;
import com.shop.service.order.bean.User;
import com.shop.service.order.exception.GenericException;

@RestController
@RequestMapping("orders")
public class ServiceController {
	private List<Order> orderList;
	private final RestTemplate restTemplate;
	private static final String USER_API_PATH = "http://localhost:7171/users";

	@Autowired
	public ServiceController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		populateOrders();
	}
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findAllOrders() {
		return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/{orderID}", method = RequestMethod.GET)
	public Order findOrder(@PathVariable("orderID") Long orderID) {
		Order fetchedOrder = null;
		try {
			fetchedOrder = orderList.stream().filter(order -> orderID.intValue() == order.getOrderID().intValue()).findAny()
					.orElse(null);
			if(fetchedOrder != null) {
				User fetchedUser = fetchedOrder.getUser();
				if(fetchedUser != null) {
					User user = this.restTemplate.getForObject(USER_API_PATH + "/{userID}", User.class,fetchedUser.getUserID());
					if(user != null) {
						fetchedOrder.setUser(user);
					}
				}
			}else {
				throw new GenericException("Order not found.");
			}
			return fetchedOrder;
		} catch (Exception e) {
			return fetchedOrder;
		}
	}
	
	private List<Order> populateOrders() {
		orderList = new ArrayList<>();
		Order order1 = new Order();
		order1.setOrderID(new Long(2000));
		User user1 = new User(new Long(1000));
		order1.setUser(user1);
		order1.setTotalPrice(1000.89);
		orderList.add(order1);
		Order order2 = new Order();
		order2.setOrderID(new Long(2001));
		User user2 = new User(new Long(1001));
		order2.setUser(user2);
		order2.setTotalPrice(350.50);
		orderList.add(order2);
		return orderList;
	}
}