package com.javatpoint.mypackage;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class TablePerSubclass {  
	public static void main(String[] args) {  
	          
	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	  
	SessionFactory factory=meta.buildSessionFactory();  
	Session session=factory.openSession();  
	  
	Transaction t=session.beginTransaction();    
	  
	EmpInherit e1=new EmpInherit();    
	e1.setName("Viren Sharma");    
	    
	Regular_Employee e2=new Regular_Employee();    
	e2.setName("Vivek Kumar");    
	e2.setSalary(50000);    
	e2.setBonus(5);    
	    
	Contract_Employee e3=new Contract_Employee();    
	e3.setName("Arjun Kumar");    
	e3.setPay_per_hour(1000);    
	e3.setContract_duration("15 hours");    
	    
	session.persist(e1);    
	session.persist(e2);    
	session.persist(e3);    
	    
	t.commit();    
	session.close();    
	System.out.println("success");    
	  
	}  
}  
