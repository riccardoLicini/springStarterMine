package com.riky.spring.starter.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Address {
	
	@NotNull
	private String street;
	
	@NotNull
	@Pattern(regexp = "^\\d*$")
	private String number;
	
	@NotNull
	private String country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
