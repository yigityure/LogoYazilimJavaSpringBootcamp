package com.logo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.logo.model.enums.CustomerTpe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private int age;
	@Enumerated(EnumType.ORDINAL)
	private CustomerTpe customerType;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Customer( String name, int age, CustomerTpe customerType) {
		this.name = name;
		this.age = age;
		this.customerType = customerType;
	}

	public Customer(Integer id, int age, CustomerTpe customerType) {
		this.id = id;
		this.age = age;
		this.customerType = customerType;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public CustomerTpe getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerTpe customerType) {
		this.customerType = customerType;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
