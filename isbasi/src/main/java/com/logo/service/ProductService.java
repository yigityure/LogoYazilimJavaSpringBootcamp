package com.logo.service;

import com.logo.model.Product;
import com.logo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

//	public String url = "default url";
//	public String username = "default username";
//	public String password = "default password";
//
//	public ProductService() {
//		super();
//	}

//	public ProductService(String url, String username, String password) {
//		super();
//		this.url = url;
//		this.username = username;
//		this.password = password;
//	}

    public List<Product> getAllProducts() {
		return productRepository.findAll();
    }

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {

		Product foundProduct = productRepository.findById(product.getId()).get();

		foundProduct.setPrice(product.getPrice());

		return productRepository.save(foundProduct);
	}

	public void deleteProductById(Integer id) {
		Product foundProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);

		productRepository.delete(foundProduct);
	}
}
