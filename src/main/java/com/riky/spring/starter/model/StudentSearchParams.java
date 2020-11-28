package com.riky.spring.starter.model;

public class StudentSearchParams {

	private String name;
	
	public StudentSearchParams() {
		super();
	}

	public StudentSearchParams(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
