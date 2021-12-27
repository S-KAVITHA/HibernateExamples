package com.javatpoint.mypackage;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class SelectHQL {
 
    public static void main(String[] args) {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
 
        // Get All Employees
        Query query = session.createQuery("from StudentHQL");  /// java class name not table name
        
        List<StudentHQL> list = (List<StudentHQL>) query.list();
        for (StudentHQL st : list) {
            System.out.println("List of Employees::" + st.getId() + "," + st.getName() + "," + st.getDegree());
        }
        
        // Get Employee with id
        query = session.createQuery("from StudentHQL where id= :id");
        query.setLong("id", 7);
        StudentHQL stu = (StudentHQL) query.uniqueResult();
        System.out.println("Student Name=" + stu.getName() + ", Degre=" + stu.getDegree());
 
        tx.commit();
        session.close();
        factory.close();
    }
}
