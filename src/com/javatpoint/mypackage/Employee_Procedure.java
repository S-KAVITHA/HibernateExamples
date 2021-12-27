package com.javatpoint.mypackage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity 
@Table(name= "employee_proc")
public class Employee_Procedure {
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int eid;
    private String ename;
    private String edesig;
    private String edept;
    private int esal;
 
    public int getEid() {
        return eid;
    }
 
    public void setEid(int eid) {
        this.eid = eid;
    }
 
    public String getEname() {
        return ename;
    }
 
    public void setEname(String ename) {
        this.ename = ename;
    }
 
    public String getEdesig() {
        return edesig;
    }
 
    public void setEdesig(String edesig) {
        this.edesig = edesig;
    }
 
    public String getEdept() {
        return edept;
    }
 
    public void setEdept(String edept) {
        this.edept = edept;
    }
 
    public int getEsal() {
        return esal;
    }
 
    public void setEsal(int esal) {
        this.esal = esal;
    }
 
    @Override
    public String toString() {
        return "Employee_Procedure [eid=" + eid + ", ename=" + ename + ", edesig=" + edesig + ", edept=" + edept + ", esal="
                + esal + "]";
    }
}
