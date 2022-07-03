package com.logo.service;

import com.logo.model.Order;
import com.logo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class OrderService {

//	@Autowired
//	private ProductService productService;

	@Autowired
	private OrderRepository orderRepository;


	public List<Order> getAllOrders() {

		return orderRepository.findAll();
	}

	public Order createOrder(Order order) {

//		System.out.println("OrderService - productService:" + productService.toString());
//
//		System.out.println("OrderService - productService:" + productService.url);


		orderRepository.save(order);

		return order;
	}

	public Order updateOrder(Order order) {

		Order foundOrder = orderRepository.findById(order.getId()).get();

		foundOrder.setCreatedDate(order.getCreatedDate());

		return orderRepository.save(foundOrder);
	}

	public void deleteOrderById(Integer id) {
		Order foundOrder = orderRepository.findById(id).orElseThrow(RuntimeException::new);

		orderRepository.delete(foundOrder);
	}
}
