package com.javatpoint.mypackage;

import java.util.HashMap;    
import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;    
  
  
public class MapCollectionMain {    
public static void main(String[] args) {    
   
    /*StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
      */
    
    Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");

    
    /*SessionFactory factory=meta.getSessionFactoryBuilder().build();  
    Session session=factory.openSession();  */
    SessionFactory factory = cfg.buildSessionFactory();
    
    Session session = factory.openSession();
    
    
	Transaction t=session.beginTransaction();    
	    
	HashMap<String,String> map1=new HashMap<String,String>();    
	map1.put("PHP is a programming language","Micheal1 ");    
	map1.put("PHP is a platform","Ajay Sharma1");    
	map1.put("PHP is a programming language","Micheal1 ");    
	map1.put("PHP is a platform","Ajay Sharma1");    
	        
	
	
	HashMap<String,String> map2=new HashMap<String,String>();    
	map2.put("JSTL technology is a server side programming","Micheal1");    
	map2.put("JSTL is an Interface","Ajay1");    
	map2.put("JSTL is a package","Rahul Kumar1");    
	    
	QuestionMap question1=new QuestionMap("What is PHP?","Aman1",map1);    
	QuestionMap question2=new QuestionMap("What is JSTL?","Jai1",map2);    
	    
	session.persist(question1);    
	session.persist(question2);    
	    
	t.commit();    
	session.close();    
	System.out.println("successfully stored");    
}    
}    
