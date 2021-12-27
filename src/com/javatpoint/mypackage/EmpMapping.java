package com.javatpoint.mypackage;

public class EmpMapping {

	private int employeeId;  
	private String name,email;  
	private AdressMapping address;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AdressMapping getAddress() {
		return address;
	}
	public void setAddress(AdressMapping address) {
		this.address = address;
	} 
	
	
	
}
