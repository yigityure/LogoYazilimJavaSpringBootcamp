package com.logo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.logo.model.Customer;
import com.logo.model.Supplier;
import com.logo.model.User;

@Repository
public class UserRepository {

	private static List<User> userList = new ArrayList<>();

	public User save(User request) {
		request.getCustomerList().add(new Customer("Onur", 23, new ArrayList<>()));
		request.getCustomerList().add(new Customer("Gizem", 23, new ArrayList<>()));
		request.getCustomerList().add(new Customer("Ceylan", 23, new ArrayList<>()));
		request.getSupplierList().add(new Supplier("Ercanlar", "Tekstil", new ArrayList<>()));
		request.getSupplierList().add(new Supplier("Bimak", "Mobilya", new ArrayList<>()));
		userList.add(request);
		return request;
	}

	public List<User> findAll() {
		return userList;
	}
	
	// Aktif ve pasif kullanıcılar
	public List<User> findAll(boolean isActive) {
		return userList.stream().filter(user -> user.isActive() == isActive).collect(Collectors.toList());
	}

	public Optional<User> findByEmail(String email) {
		return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst();
	}

	
	// Customer için CRUD
	public Customer saveCustomer(Customer request, String email) {
		User foundedUser = userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
		foundedUser.getCustomerList().add(request);
		return request;
	}


	public Customer updateCustomer(Customer request, String email) {
		User foundedUser = userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
		Customer foundedCustomer = foundedUser.getCustomerList().stream().filter(customer -> customer.getName().equals(request.getName())).findFirst().get();
		foundedCustomer.setAge(request.getAge());
		foundedCustomer.setOrderList(request.getOrderList());
		return request;
	}

	public void deleteCustomer(String customerName, String email) {
		User foundedUser = userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
		Customer foundedCustomer = foundedUser.getCustomerList().stream().filter(customer -> customer.getName().equals(customerName)).findFirst().get();
		foundedUser.getCustomerList().remove(foundedCustomer);
	}
	
	// Supplier için CRUD
	public Supplier saveSupplier(Supplier request, String email) {
		User foundedUser = userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
		foundedUser.getSupplierList().add(request);
		return request;
	}

	public Supplier updateSupplier(Supplier request, String email) {
		User foundedUser = userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
		Supplier foundedSupplier = foundedUser.getSupplierList().stream().filter(supplier -> supplier.getName().equals(request.getName())).findFirst().get();
		foundedSupplier.setSector(request.getSector());
		foundedSupplier.setOrderList(request.getOrderList());
		return request;
	}

	public void deleteSupplier(String supplierName, String email) {
		User foundedUser = userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
		Supplier foundedSupplier = foundedUser.getSupplierList().stream().filter(customer -> customer.getName().equals(supplierName)).findFirst().get();
		foundedUser.getSupplierList().remove(foundedSupplier);
	}

}
