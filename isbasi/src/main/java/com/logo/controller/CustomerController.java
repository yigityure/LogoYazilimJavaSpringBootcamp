package com.logo.controller;

import com.logo.model.Customer;
import com.logo.model.User;
import com.logo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllUsers() {
		return customerService.getAllCustomers();
	}

	@PostMapping("/{id}")
	public Customer createCustomer(@RequestBody Customer customerRequest, @PathVariable int id) {
		return customerService.createCustomer(customerRequest, id);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		return customerService.updateCustomer(customer, id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomerById(id);
	}

}
