package com.javatpoint.mypackage;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AnnotationManyToMany 
{
    public static void main( String[] args )
    {
       Configuration cfg= new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();
       Session session= factory.openSession();
       
       Categories cate1 = new Categories();
       cate1.setCate_id(03);
       cate1.setCate_name("category 03");
       
       Categories cate2 = new Categories();
       cate2.setCate_id(04);
       cate2.setCate_name("category 04");
       
       Items i= new Items();
       i.setItem_id(33);
       i.setItem_name("item 33");
       
       Items i2 =new Items();
       i2.setItem_id(34);
       i2.setItem_name("item 34");
       
       Set set= new HashSet();
       set.add(i);
       set.add(i2);
       
       cate1.setItems(set);
       cate2.setItems(set);
       
       Transaction t= session.beginTransaction();
       session.save(cate1);
       session.save(cate2);
       
       t.commit();
       
       System.out.println("saved successfully!!!!");
       session.close();
    }
} 
