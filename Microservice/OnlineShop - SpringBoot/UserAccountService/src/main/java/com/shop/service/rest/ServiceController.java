package com.shop.service.rest;

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

import com.shop.service.bean.User;

@RestController
@RequestMapping("users")
public class ServiceController {
	private List<User> userList;

	@Autowired
	public ServiceController() {
		populateUsers();
	}
	@CrossOrigin
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{userID}", method = RequestMethod.GET)
	public ResponseEntity<User> findUser(@PathVariable("userID") Long userID) {
		User filteredUser = userList.stream().filter(user -> userID.intValue() == user.getUserID().intValue()).findAny()
				.orElse(null);
		if(filteredUser != null) {
			return new ResponseEntity<User>(filteredUser, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAllUser() {
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	private List<User> populateUsers() {
		userList = new ArrayList<>();
		User user1 = new User(new Long(1000),"Tapas","Dey","918792290625","Bangalore,ITPL Main Road,Karnatka-777777,India");
		userList.add(user1);
		User user2 = new User(new Long(1001),"Amal","Das","91-8792290626","Kolkata,ITPL Main Road,Karnatka,India");
		userList.add(user2);
		return userList;
	}
}