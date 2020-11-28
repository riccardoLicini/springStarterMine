package com.riky.spring.starter.entity;

public class Education {

	private Degree master;
	private Degree phd;
	
	public Degree getMaster() {
		return master;
	}
	public void setMaster(Degree master) {
		this.master = master;
	}
	public Degree getPhd() {
		return phd;
	}
	public void setPhd(Degree phd) {
		this.phd = phd;
	}
}
