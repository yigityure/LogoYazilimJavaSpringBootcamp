package com.logo.dao;

import com.logo.model.Address;
import com.logo.model.AddressRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Address> findAll() {
        String sql = "SELECT * FROM address";
        return jdbcTemplate.query(sql, new AddressRowMapper());
    }

    @Override
    public int add(Address address) {
        String sql = "INSERT into address(id,country,province,address) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, address.getId(), address.getCountry(), address.getProvince(), address.getAddress());
    }

    @Override
    public int update(int id, Address address) {
        String sql = "UPDATE address SET country = ?, province = ?, address = ? WHERE id = ?";
        return jdbcTemplate.update(sql, address.getCountry(), address.getProvince(), address.getAddress(), id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM address WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
