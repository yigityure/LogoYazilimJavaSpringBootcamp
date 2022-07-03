package com.logo.controller;

import com.logo.model.Order;
import com.logo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@PostMapping
	public Order createOrder(@RequestBody Order orderRequest) {
		return orderService.createOrder(orderRequest);
	}

	@PutMapping
	public Order updateOrder(Order order) {
		return orderService.updateOrder(order);
	}

	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteOrder(@PathParam("orderId") Integer orderId) {
		orderService.deleteOrderById(orderId);
	}

}
