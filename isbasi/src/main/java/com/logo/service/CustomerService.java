package com.logo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.logo.dto.EmailDto;
import com.logo.model.*;
import com.logo.repository.CustomerRepository;
import com.logo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.enums.CustomerTpe;

@Service
public class CustomerService {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserRepository userRepository;

	public CustomerService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

//	public Customer create(String name) {
//		Customer customer = Customer.builder().name("Cem").age(28).customerType(CustomerTpe.Customer).build();
//
//		System.out.println("orderService:" + orderService.toString());
//
//		System.out.println("productService:" + productService.toString());
//
//		return customer;
//	}

	private List<Customer> prepareCustomerList() {
		List<Customer> customers = new ArrayList<>();
//		customers.add(Customer.builder().name("Cem").age(28).customerType(CustomerTpe.Customer).build());
//		customers.add(Customer.builder().name("Emir").age(28).customerType(CustomerTpe.Customer).build());
		return customers;
	}

//	private List<Order> prepareOrderList() {
//		List<Order> orders = new ArrayList<>();
//		int randomOrderNumber = new Random().nextInt(5);
//		for (int i = 0; i < randomOrderNumber; i++) {
//			Order order = new Order(prepareProductList(randomOrderNumber));
//			orders.add(order);
//		}
//		return orders;
//	}

	private List<Product> prepareProductList(int randomOrderNumber) {
		List<Product> products = new ArrayList<>();
		Random random = new Random();
		products.add(new Product("MacBook Pro", random.nextDouble(1000)));
		products.add(new Product("MacBook air", random.nextDouble(1000)));
		products.add(new Product("Mac Mini", random.nextDouble(1000)));
		products.add(new Product("iPhone 11", random.nextDouble(1000)));
		products.add(new Product("iPhone 12", random.nextDouble(1000)));

		return products.stream().limit(randomOrderNumber).toList();
	}

	public List<Customer> getAllCustomers() {

		// ProductService productService = new ProductService;
		// singleton olduğunun kanıtı
//		System.out.println("CustomerService - productService:" + productService.toString());
//		System.out.println("CustomerService - productService:" + productService.url);
//		System.out.println("CustomerService - orderService:" + orderService.toString());

		//orderService.createOrder();

		//return prepareCustomerList();
		return customerRepository.findAll();
	}

	public Customer createCustomer(Customer customer, int id) {
		//rabbitTemplate.convertAndSend("isbasi.email", new EmailDto("user@gmail.com", "Java Dev",
		//		"Patika eğitimleri ile java developer yetiştirilmek istenmektedir."));

		User user = userRepository.findById(id).get();
		customer.setUser(user);
		user.getCustomerList().add(customer);

		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer, int id) {
		Customer foundCustomer = customerRepository.findById(id).get();

		foundCustomer.setCustomerType(customer.getCustomerType());
		foundCustomer.setAge(customer.getAge());

		return customerRepository.save(foundCustomer);
	}

	public void deleteCustomerById(int id) {
		Customer foundCustomer = customerRepository.findById(id).orElseThrow(RuntimeException::new);

		customerRepository.delete(foundCustomer);
	}
}
