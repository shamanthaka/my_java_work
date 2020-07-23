package com.shamanthaka.assignment2;

import java.util.Objects;

public class Employee2  extends Object{

    private String name;
    private  int empId;

    public Employee2(String name, int empId){
        this.name = name;
        this.empId = empId;
    }
    public String getName(){
        return this.name;
    }

    public int getEmpId()
    {
        return this.empId;
    }

    public boolean equals(Object obj){
        Employee2 emp = (Employee2) obj;
        return this.name.equals(emp.getName()) && this.empId == emp.getEmpId();
    }

    public int hashCode(){
        return Objects.hash(empId);
    }
}
