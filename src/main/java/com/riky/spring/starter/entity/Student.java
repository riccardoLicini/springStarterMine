package com.riky.spring.starter.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Student {
	
	@Id
	private String id;
	private String name;
	private List<Address> addresses;
	private Education education;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
}
