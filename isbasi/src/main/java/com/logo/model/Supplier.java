package com.logo.model;

import java.util.List;

public class Supplier {
	
	private String name;
	private String sector;
	private List<Order> orderList;
	
	public Supplier(String name, String sector, List<Order> orderList) {
		super();
		this.name = name;
		this.sector = sector;
		this.orderList = orderList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	

}
