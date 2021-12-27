package com.javatpoint.mypackage;

import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;    
    
public class OneToOneMapping {    
public static void main(String[] args) {    
 /*     
    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
    Session session=factory.openSession();  
      */
	
	Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");

    SessionFactory factory = cfg.buildSessionFactory();
    Session session = factory.openSession();
    
    Transaction t=session.beginTransaction();   
      
    EmpMapping e1=new EmpMapping();    
    e1.setName("Akash Sharma");    
    e1.setEmail("Akash@yhaoo.com");    
        
    AdressMapping address1=new AdressMapping();    
    address1.setAddressLine1("H-22,Lohia nagar");    
    address1.setCity("Punjab");    
    address1.setState("Haryana");    
    address1.setCountry("India");    
    address1.setPincode(201320);    
        
    e1.setAddress(address1);    
    address1.setEmployee(e1);    
        
    session.persist(e1);    
    t.commit();    
        
    session.close();    
    System.out.println("success");    
   }    
}    
