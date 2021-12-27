package com.javatpoint.mypackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 

public class OneToManyMapping {
	
   private static SessionFactory factory; 
   public static void main(String[] args) {
      
      try {
        factory = new Configuration().configure().buildSessionFactory();
         
                
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      OneToManyMapping ME = new OneToManyMapping();
      
      /* Let us have a set of certificates for the first employee  */
  /*   HashSet set1 = new HashSet();
      set1.add(new CertiOntoMany("Java"));
      set1.add(new CertiOntoMany("Oracle"));
      set1.add(new CertiOntoMany("PHP"));
     
       Add employee records in the database 
      Integer empID1 = ME.addEmployee("Manoj", "Tiwari", 9000, set1);
      System.out.println(">>>>>>>>>>>>>>> empID1>>   " + empID1);

       Another set of certificates for the second employee  
      HashSet set2 = new HashSet();
      set2.add(new CertiOntoMany("Design Thinking")); 
      set2.add(new CertiOntoMany("Digital Marketing"));

        Add another employee record in the database 
      Integer empID2 = ME.addEmployee("Kiran", "Shah", 4500, set2);
      System.out.println(">>>>>>>>>>>>>>> empID2>>  " +empID2);*/

      
      /* List down all the employees */
         ME.listEmployees();  
   

      /* Update employee's salary records */
       int  empID1 = 1;
       ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
       int empID=2; // put the emp id here which is to be deleted
       ME.deleteEmployee(empID);

      /* List down all the employees */
       ME.listEmployees();

   }

   /* Method to add an employee record in the database */
   public Integer addEmployee(String fname, String lname, int salary, Set cert){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      
      try {
         tx = session.beginTransaction();   
         
         EmpOnToMany employee = new EmpOnToMany(fname, lname, salary);
         employee.setCertificates(cert);
         employeeID = (Integer) session.save(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return employeeID;
   }

   /* Method to list all the employees detail */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM EmpOnToMany").list(); 
         
         //in query java enity name will come
         for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();){
        	 EmpOnToMany employee = (EmpOnToMany) iterator1.next(); 
        	 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary());
            
            Set certificates = employee.getCertificates();
            for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
            	CertiOntoMany certName = (CertiOntoMany) iterator2.next(); 
               System.out.println("Certificate: " + certName.getName()); 
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
        // session.close(); 
      }
   }
   
   /* Method to update salary for an employee */
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         EmpOnToMany employee = (EmpOnToMany)session.get(EmpOnToMany.class, EmployeeID); 
         employee.setSalary( salary );
         session.update(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
       //  session.close(); 
      }
   }
   
   /* Method to delete an employee from the records */
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         
         EmpOnToMany employee = (EmpOnToMany)session.get(EmpOnToMany.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
        // session.close(); 
      }
   }
}
