package com.javatpoint.mypackage;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.javatpoint.mypackage.HQLEmployee;

public class HibernateCriteriaExamples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		 Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	 
	    SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		//Get All Employees
		Criteria criteria = session.createCriteria(HQLEmployee.class);
		List<HQLEmployee> empList = criteria.list();
		for(HQLEmployee emp : empList){
			System.out.println("ID="+emp.getId()+", Zipcode="+emp.getAddress().getZipcode());
		}
		
		// Get with ID, creating new Criteria to remove all the settings
		criteria = session.createCriteria(HQLEmployee.class).add(Restrictions.eq("id", new Long(3)));
		HQLEmployee emp = (HQLEmployee) criteria.uniqueResult();
		System.out.println("Name=" + emp.getName() + ", City="
				+ emp.getAddress().getCity());

		//Like example
		empList = session.createCriteria(HQLEmployee.class).add(Restrictions.like("name", "%i%")).list();
		for(HQLEmployee emp4 : empList){
			System.out.println("Employees having 'i' in name::"+emp4.getName()+","+emp4.getAddress().getCity());
		}
		
		//Join example for selecting few columns
		criteria = session.createCriteria(HQLEmployee.class, "employee");
		criteria.setFetchMode("employee.address", FetchMode.JOIN);
		criteria.createAlias("employee.address", "address"); // inner join by default

		// Hibernate Criteria API can be used with ProjectionList to fetch selected columns only.
		ProjectionList columns = Projections.projectionList()
						.add(Projections.property("name"))
						.add(Projections.property("address.city"));
		criteria.setProjection(columns);

		List<Object[]> list = criteria.list();
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
			
		// Rollback transaction to avoid messing test data
		tx.commit();
		// closing hibernate resources
		sessionFactory.close();
	}

}