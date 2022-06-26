package com.logo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.Customer;
import com.logo.model.Supplier;
import com.logo.model.User;
import com.logo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public User createUser(User request) {
				
		rabbitTemplate.convertAndSend("isbasi.email", request.getEmail());
		
		//rabbitMQService.sendEmail(request.getEmail());
		
		return userRepository.save(request);
	}

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}
	
	// Aktif ve pasif kullanıcılar
	public List<User> getAllUsers(boolean isActive) {
		return userRepository.findAll(isActive);
	}

	public User getUserByEmail(String email) {
		//kullanıcı bulunamadığında hata verilmeli
		
		//userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());
		
		//userRepository.findByEmail(email).orElseThrow(RuntimeException::new);

		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			return userRepository.findByEmail(email).get();
		}
		// null dönme
		return null;

	}
	
	
	// CustomerService için CRUD
	public List<Customer> getCustomersByEmail(String email) {
		Optional<User> foundUser = userRepository.findByEmail(email);

		if (foundUser.isPresent()) {
			return foundUser.get().getCustomerList();
		}

		return null;
	}
	
	
	public Customer createCustomerByEmail(Customer request, String email) {
		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			return userRepository.saveCustomer(request, email);
		}
		
		return null;
	}


	public Customer updateCustomerByEmail(Customer request, String email) {
		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			return userRepository.updateCustomer(request, email);
		}
		
		return null;
	}

	public void deleteCustomerByEmail(String email, String customerName) {
		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			userRepository.deleteCustomer(customerName, email);
		}
		
	}
	
	
	// SupplierService için CRUD
	public List<Supplier> getSuppliersByEmail(String email) {
		Optional<User> foundUser = userRepository.findByEmail(email);

		if (foundUser.isPresent()) {
			return foundUser.get().getSupplierList();
		}

		return null;
	}
	
	public Supplier createSupplierByEmail(Supplier request, String email) {
		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			return userRepository.saveSupplier(request, email);
		}
		
		return null;
	}

	public Supplier updateSupplierByEmail(Supplier request, String email) {
		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			return userRepository.updateSupplier(request, email);
		}
		
		return null;
	}

	public void deleteSupplierByEmail(String email, String supplierName) {
		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			userRepository.deleteSupplier(supplierName, email);
		}
		
	}

	
	

}
