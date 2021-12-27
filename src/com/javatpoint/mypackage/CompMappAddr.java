package com.javatpoint.mypackage;

public class CompMappAddr {

	private String city,country;  
	private int pincode;
	
	public CompMappAddr(){}
	
	public CompMappAddr(String city, String country, int pincode)
	{
		this.city=city;
		this.country=country;
		this.pincode=pincode;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}  
	  
	
}
