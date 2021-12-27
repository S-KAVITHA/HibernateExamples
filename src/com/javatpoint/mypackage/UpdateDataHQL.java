package com.javatpoint.mypackage;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class UpdateDataHQL {
 
    public static void main(String[] args) {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
 
        // Update Employee
        Query query = session.createQuery("update StudentHQL set name= :name where id= :id");
        query.setParameter("name", "Amit Raj");
        query.setLong("id", 5);
        int result = query.executeUpdate(); // to update the query
        System.out.println("Student data Update Status=" + result);
 
        // Delete Employee, we need to take care of foreign key constraints too
        query = session.createQuery("delete from StudentHQL where id= :id");
        query.setLong("id", 8);
        result = query.executeUpdate();
        System.out.println("Student Data Delete Status=" + result);
 
        tx.commit();
        session.close();
        factory.close();
    }
}