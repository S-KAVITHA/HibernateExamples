package com.javatpoint.mypackage;

public class CompMappEmp {

	private int id;  
	private String name;  
	private CompMappAddr address;  //HAS-A  
	
	public CompMappEmp(){}
	
	public CompMappEmp(String name, CompMappAddr address)
	{
		this.name=name;
		this.address=address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CompMappAddr getAddress() {
		return address;
	}
	public void setAddress(CompMappAddr address) {
		this.address = address;
	}
	  
	
}
