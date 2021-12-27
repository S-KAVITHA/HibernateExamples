package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ComponentMapping {
public static void main(String[] args) {
	
	Session s=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	
	CompMappEmp e1=new CompMappEmp("amit",new CompMappAddr("gzb","india",221233));
	CompMappEmp e2=new CompMappEmp("Vijay",new CompMappAddr("noida","india",224123));
	
	Transaction t=s.beginTransaction();
	
	s.save(e1);
	s.save(e2);
	
	t.commit();
	s.close();
	
	System.out.println("success...");
}
}
