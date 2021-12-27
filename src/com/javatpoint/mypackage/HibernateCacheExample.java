package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.javatpoint.mypackage.HQLEmployee;

public class HibernateCacheExample {

	public static void main(String[] args) throws InterruptedException {
		
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	 
	    SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//Get employee with id=1
		HQLEmployee emp = (HQLEmployee) session.load(HQLEmployee.class, new Long(1));
		printData(emp,1);
		
		//waiting for sometime to change the data in backend for 10 secs
		Thread.sleep(8000);
		
		//Fetch same data again, check logs that no query fired
		HQLEmployee emp1 = (HQLEmployee) session.load(HQLEmployee.class, new Long(1));
		printData(emp1,2);
		
		//Create new session
		Session newSession = sessionFactory.openSession();
		//Get employee with id=1, notice the logs for query
		HQLEmployee emp2 = (HQLEmployee) newSession.load(HQLEmployee.class, new Long(1));
		printData(emp2,3);
		
		//START: evict example to remove specific object from hibernate first level cache
		//Get employee with id=2, first time hence query in logs
		HQLEmployee emp3 = (HQLEmployee) session.load(HQLEmployee.class, new Long(2));
		printData(emp3,4);
		
		//evict the employee object with id=1
		session.evict(emp); // used to remove
		System.out.println("Session Contains Employee with id=1?"+session.contains(emp));

		//since object is removed from first level cache, you will see query in logs
		HQLEmployee emp4 = (HQLEmployee) session.load(HQLEmployee.class, new Long(1));
		printData(emp4,5);
		
		//this object is still present, so you won't see query in logs
		HQLEmployee emp5 = (HQLEmployee) session.load(HQLEmployee.class, new Long(2));
		printData(emp5,6);
		//END: evict example
		
		//START: clear example to remove everything from first level cache
		session.clear();
		HQLEmployee emp6 = (HQLEmployee) session.load(HQLEmployee.class, new Long(1));
		printData(emp6,7);
		HQLEmployee emp7 = (HQLEmployee) session.load(HQLEmployee.class, new Long(2));
		printData(emp7,8);
		
		System.out.println("Session Contains Employee with id=2?"+session.contains(emp7));
		
		tx.commit();
		sessionFactory.close();
	}

	private static void printData(HQLEmployee emp, int count) {
		System.out.println(count+":: Name="+emp.getName()+", Zipcode="+emp.getAddress().getZipcode());
	}

}
