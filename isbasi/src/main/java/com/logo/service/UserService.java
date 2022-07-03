package com.logo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.logo.model.enums.CustomerTpe;
import com.logo.repository.CustomerRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.dto.EmailDto;
import com.logo.model.Address;
import com.logo.model.Customer;
import com.logo.model.User;
import com.logo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RabbitMQService rabbitMQService;

	@Autowired
	private AmqpTemplate rabbitTemplate;
	@Autowired
	CustomerRepository customerRepository;
	public User createUser(User user) {
//		rabbitTemplate.convertAndSend("isbasi.email", new EmailDto("user@gmail.com", "Java Dev",
//				"Patika eğitimleri ile java developer yetiştirilmek istenmektedir."));

		Address address = new Address("Türkiye", "İstanbul", "Açık address");

		user.setAddress(address);

//		List<Customer> customers = new ArrayList<>();
//
//		customers.add(new Customer("asd",21, CustomerTpe.CORPORATE));
//		customers.add(new Customer("awe",21,CustomerTpe.CORPORATE));
//		customers.add(new Customer("asd",21,CustomerTpe.INDIVIUAL));
//		customers.add(new Customer("zxc",21,CustomerTpe.CORPORATE));
//		customers.add(new Customer("asdf",21,CustomerTpe.INDIVIUAL,user));
//		customers.add(new Customer("adv",21,CustomerTpe.CORPORATE));



		userRepository.save(user);
//		Customer customer1 = new Customer("asd",21, CustomerTpe.CORPORATE);
//		Customer customer2 = new Customer("awe",21, CustomerTpe.INDIVIUAL);
//		Customer customer1 = Customer.builder().user(user).age(21).build();
//		Customer customer2 = Customer.builder().user(user).age(12).build();
//		List<Customer> customers1 = new ArrayList<>();
//		List<Customer> customers = user.getCustomerList();
//		customers.stream().forEach(customer -> customers1.add(Customer.builder().user(user).name(customer.getName()).build()));
		user.getCustomerList().add(Customer.builder().user(user).age(21).build());
		user.getCustomerList().add(Customer.builder().user(user).age(12).build());
		customerRepository.saveAll(user.getCustomerList());
//		customerRepository.save(customer1);
//		customerRepository.save(customer2);

//		user.setCustomerList(new ArrayList<>());
//		customers1.stream().forEach(customer -> user.getCustomerList().add(customer));
//		user.getCustomerList().addAll(customers1);
//		user.getCustomerList().add(customer1);
//		user.getCustomerList().add(customer2);
		return user;



//		user.setCustomerList(customers);
//
//
////		customers.stream().forEach(customer -> customer.setUser(user));
//		customers.stream().forEach(customer -> customerRepository.save(customer));
//		return userRepository.save(user);

	}

	public void deleteUserById(int id) {

		/*
		 * deleteById metodu da olabilir.
		 */
		User foundUser = userRepository.findById(id).orElseThrow(RuntimeException::new);

		userRepository.delete(foundUser);

		// userRepository.deleteAll();

		// userRepository.deleteById(id);
	}

	public void deleteUserByEmail(String email) {

		Optional<User> foundUser = userRepository.findByEmail(email);
		if (!foundUser.isPresent()) {
			log.info("user not found");
		}

		userRepository.delete(foundUser.get());

	}

	public User updateUser(User user) {

		String sql = "Update User set email = yeniemail where id =1";

		User foundUser = userRepository.findById(user.getId()).get();

		foundUser.setEmail(user.getEmail());
		foundUser.setSurname(user.getSurname());

		return userRepository.save(foundUser);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserByEmail(String email) {
		/*
		 * kullanıcı bulunamadığında hata verilmeli. Aşağıdaki iki kullanım da olabilir.
		 * Kendi Exception classımızı oluşturmamız gerek
		 */

		// userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());

		// userRepository.findByEmail(email).orElseThrow(RuntimeException::new);

		Optional<User> foundUser = userRepository.findByEmail(email);

		boolean isPresent = foundUser.isPresent();
		if (isPresent) {
			return foundUser.get();
		}
		// null dönme!
		return null;

	}

	public List<Customer> getCustomersByEmail(String email) {
		User foundUser = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());

		return foundUser.getCustomerList();
	}

}
