package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AnnotationTest {
	public static void main(String[] args) {
		
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();
		
		StudentAnnotation student1 = new StudentAnnotation();
		student1.setId(2);
		student1.setName("Ravi");
		student1.setRoll("102");
		student1.setDegree("B.E");
		student1.setPhone("934499");

		
		StudentAnnotation student2 = new StudentAnnotation();
		student2.setId(1);
		student2.setName("Mukesh");
		student2.setRoll("101");
		student2.setDegree("B.E");
		student2.setPhone("99999");
		
		session.save(student1);
		session.save(student2);

		t.commit();
		session.close();
		System.out.println("successfully saved");

	}
}
