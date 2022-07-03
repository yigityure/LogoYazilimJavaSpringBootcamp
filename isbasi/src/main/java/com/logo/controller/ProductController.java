package com.logo.controller;

import com.logo.model.Product;
import com.logo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping
	public Product createOrder(@RequestBody Product productRequest) {
		return productService.createProduct(productRequest);
	}

	@PutMapping
	public Product updateOrder(Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCustomer(@PathParam("productId") Integer productId) {
		productService.deleteProductById(productId);
	}

}
