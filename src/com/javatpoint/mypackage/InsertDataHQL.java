package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class InsertDataHQL {
 
    public static void main(String[] args) {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        
        StudentHQL student = new StudentHQL();
        student.setName("Hemanth");
        student.setRoll("104");
        student.setPhone("989876");
        student.setDegree("B.Com");
 
        StudentHQL student1 = new StudentHQL();
        student1.setName("Mukesh");
        student1.setRoll("103");
        student1.setPhone("999954");
        student1.setDegree("B.Com");
 
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(student1);
        
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        
        session.close();
        factory.close();
    }
}
