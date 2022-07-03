package com.logo.service;

import com.logo.model.Address;
import com.logo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class AddressService {

	@Autowired
	private ProductService productService;

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getAllAddresses() {

		return addressRepository.findAll();
	}

	public Address createAddress(Address address) {

		return addressRepository.save(address);
	}

	public Address updateAddress(Address address) {

		Address foundAddress = addressRepository.findById(address.getId()).get();

		foundAddress.setCountry(address.getCountry());
		foundAddress.setProvince(address.getProvince());
		foundAddress.setAddress(address.getAddress());

		return addressRepository.save(foundAddress);
	}

	public void deleteAddressById(Integer id) {
		Address foundAddress = addressRepository.findById(id).orElseThrow(RuntimeException::new);

		addressRepository.delete(foundAddress);
	}
}
