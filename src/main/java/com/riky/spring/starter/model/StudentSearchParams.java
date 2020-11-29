package com.riky.spring.starter.model;

public class StudentSearchParams {

	private String name;
	private EducationLevel educationLevel;
	
	public StudentSearchParams() {
		super();
	}


	public StudentSearchParams(String name, EducationLevel educationLevel) {
		super();
		this.name = name;
		this.educationLevel = educationLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}
}
