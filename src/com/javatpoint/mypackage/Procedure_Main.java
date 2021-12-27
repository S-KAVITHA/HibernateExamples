/*package com.javatpoint.mypackage;

import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
  
public class Procedure_Main {
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {        
        // Creating the configuration instance & passing the hibernate configuration file.
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
 
        // Hibernate session object to start the db transaction.
        Session s = config.buildSessionFactory().openSession();
 
        // Fetching the data from the database using stored procedure queries.
 
        // Stored procedure query #1
        System.out.println(":::: Find all employees ::::");
 
        StoredProcedureQuery allemployees = s.createStoredProcedureQuery("findAllEmployees", Employee_Procedure.class);
 
        List<Employee_Procedure> elist = (List<Employee_Procedure>) allemployees.getResultList();
 
        for(Employee_Procedure employee : elist) {
            System.out.println(employee.toString());
        }
 
        // Stored procedure query #2
        System.out.println("\n:::: Find employees department wise ::::");
 
        StoredProcedureQuery department = s.createStoredProcedureQuery("findEmployeeByDepartment", Employee_Procedure.class);
        department.registerStoredProcedureParameter("emp_department", String.class, ParameterMode.IN);
 
        String dparam = "Technology";
        department.setParameter("emp_department", dparam);
 
        List<Employee_Procedure> dlist = (List<Employee_Procedure>) department.getResultList();
 
        for(Employee_Procedure employee : dlist) {
            System.out.println(employee.toString());
        }
 
        // Stored procedure query #3
        System.out.println("\n:::: Find employee count by designation ::::");
 
        StoredProcedureQuery count = s.createStoredProcedureQuery("findEmployeeCountByDesignation");
        count.registerStoredProcedureParameter("emp_designation", String.class, ParameterMode.IN);
        count.registerStoredProcedureParameter("designation_count", Integer.class, ParameterMode.OUT);
 
        String param = "Lead";
        count.setParameter("emp_designation", param);
        count.execute();
 
        Integer employee_count = (Integer) count.getOutputParameterValue("designation_count");
        System.out.println("Employee count for designation= " + param + " is= " + employee_count);
 
        // Closing the session object.
        s.close();
    }
}
*/