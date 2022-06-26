package com.logo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logo.model.Customer;
import com.logo.model.Supplier;
import com.logo.model.User;
import com.logo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody User userRequest) {
		return userService.createUser(userRequest);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	
	// Aktif ve pasif kullanıcılar
	@GetMapping(value = "/active")
	public List<User> getAllActiveUsers() {
		return userService.getAllUsers(true);
	}
	
	@GetMapping(value = "/passive")
	public List<User> getAllPassiveUsers() {
		return userService.getAllUsers(false);
	}

	@GetMapping(value = "/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	// Customer için CRUD
	@GetMapping(value = "/{email}/customers")
	public List<Customer> getCustomersUserByEmail(@PathVariable String email) {
		return userService.getCustomersByEmail(email);
	}
	
	@PostMapping(value = "/{email}/")
	public Customer createCustomerUserByEmail(@RequestBody Customer customerRequest, @PathVariable String email) {
		return userService.createCustomerByEmail(customerRequest, email);
	}
	
	@PutMapping(value = "/{email}/")
	public Customer updateCustomerUserByEmail(@RequestBody Customer customerRequest, @PathVariable String email) {
		return userService.updateCustomerByEmail(customerRequest, email);
	}
	
	@DeleteMapping(value = "/{email}/{customerName}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCustomerUserByEmail(@PathVariable String email, @PathVariable String customerName) {
		userService.deleteCustomerByEmail(email, customerName);
	}
	
	// Supplier için CRUD
	@GetMapping(value = "/{email}/suppliers")
	public List<Supplier> getSuppliersUserByEmail(@PathVariable String email) {
		return userService.getSuppliersByEmail(email);
	}
	
	@PostMapping(value = "/{email}/suppliers")
	public Supplier createSupplierUserByEmail(@RequestBody Supplier suppliererRequest, @PathVariable String email) {
		return userService.createSupplierByEmail(suppliererRequest, email);
	}
	
	@PutMapping(value = "/{email}/suppliers")
	public Supplier updateSupplierUserByEmail(@RequestBody Supplier supplierRequest, @PathVariable String email) {
		return userService.updateSupplierByEmail(supplierRequest, email);
	}
	
	@DeleteMapping(value = "/{email}/suppliers/{customerName}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteSupplierUserByEmail(@PathVariable String email, @PathVariable String supplierName) {
		userService.deleteSupplierByEmail(email, supplierName);
	}
	
}
