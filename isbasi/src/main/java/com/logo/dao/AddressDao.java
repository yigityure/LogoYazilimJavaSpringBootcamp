package com.logo.dao;

import com.logo.model.Address;

import java.util.List;

public interface AddressDao {
    List<Address> findAll();
    int add(Address address);
    int update(int id, Address address);
    int delete(int id);
}
