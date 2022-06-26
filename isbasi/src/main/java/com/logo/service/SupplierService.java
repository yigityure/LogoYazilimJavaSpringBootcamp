package com.logo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.Supplier;

@Service
public class SupplierService {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;

	public SupplierService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public Supplier create(String name, String sector) {
		Supplier supplier = new Supplier(name, sector, new ArrayList<>());

		System.out.println("orderService:" + orderService.toString());
		// orderService.createOrder();

		System.out.println("productService:" + productService.toString());

		return supplier;
	}
	
	
}
