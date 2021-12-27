package com.javatpoint.mypackage;

import java.util.ArrayList;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
    
public class BagCollectionMain {    
 public static void main(String[] args) {    
      
     StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
     Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
       
     SessionFactory factory=meta.buildSessionFactory();  
     Session session=factory.openSession();  
       
    Transaction t=session.beginTransaction();    
        
    ArrayList<String> list1=new ArrayList<String>();    
    list1.add("Hibernate is ORM & flexible");    
    list1.add("It is using JPA internally");    
        
    ArrayList<String> list2=new ArrayList<String>();    
    list2.add("Servlet is alternative to CGI");    
    list2.add("Servlet API used extensively");    
        
    QuestionBag question1=new QuestionBag();    
    question1.setQname("What is Hibernate");    
    question1.setAnswers(list1);    
        
    QuestionBag question2=new QuestionBag();    
    question2.setQname("What is Servlet");    
    question2.setAnswers(list2);    
        
    session.persist(question1);    
    session.persist(question2);    
        
    t.commit();    
    session.close();    
    System.out.println("success");    
 }    
}    
