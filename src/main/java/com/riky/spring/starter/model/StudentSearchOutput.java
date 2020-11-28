package com.riky.spring.starter.model;

import java.util.List;

import com.riky.spring.starter.entity.Student;

public class StudentSearchOutput {

	private int totalCount;
	private List<Student> data;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<Student> getData() {
		return data;
	}
	public void setData(List<Student> data) {
		this.data = data;
	}
}
