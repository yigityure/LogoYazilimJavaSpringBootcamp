package com.logo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@JsonProperty("id")
	private int id;
//	@Column(name = "country", nullable = true)
	@JsonProperty("country")
	private String country;
//	@Column(name = "province", nullable = true)
	@JsonProperty("province")
	private String province;
//	@Column(name = "address", nullable = true)
	@JsonProperty("address")
	private String address;

	public Address(String country, String province, String address) {
		super();
		this.country = country;
		this.province = province;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
