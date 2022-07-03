package com.logo.controller;

import com.logo.dao.AddressDao;
import com.logo.model.Address;
import com.logo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {
//	private final AddressDao addressDao;
//
//	@Autowired
//	public AddressController(AddressDao addressDao) {
//		this.addressDao = addressDao;
//	}
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private AddressService addressService;

	public AddressController() {
	}

	@GetMapping
	public List<Address> getAllAddresses() {
		return addressDao.findAll();
//		return addressService.getAllAddresses();
	}

	@PostMapping
	public int createAddress(@RequestBody Address addressRequest) {
		return addressDao.add(addressRequest);
//		return addressService.createAddress(addressRequest);
	}

	@PutMapping("/{id}")
	public int updateOrder(@PathVariable("id") int id, Address address) {
		return addressDao.update(id, address);
//		return addressService.updateAddress(address);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteAddress(@PathVariable("id") int id) {
		addressDao.delete(id);
//		addressService.deleteAddressById(id);
	}

}
