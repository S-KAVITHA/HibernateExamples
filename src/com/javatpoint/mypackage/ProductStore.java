package com.javatpoint.mypackage;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;  
  
public class ProductStore {  
  
    public static void main( String[] args )  
    {  
        //StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        //Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        //SessionFactory factory = meta.getSessionFactoryBuilder().build();       
        //Session session = factory.openSession();  //session is opened here
    	
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction t = session.beginTransaction(); //starting/beginning transaction 
          
        Product p1 =new Product();     // transient state
            p1.setProductId("AA100234");   
            p1.setProductdesc("Dabur Honey");  
            p1.setPrice(500.00);
            p1.setExpiry_date("12/06/2023");
         
            
       session.save(p1);  // persist state---> saving into database
      
       t.commit();  // commit() in DB
       System.out.println("successfully saved");    
        factory.close();  
        //session.close();    //detached state
    }  
}  
