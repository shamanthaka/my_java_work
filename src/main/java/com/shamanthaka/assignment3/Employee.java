package com.shamanthaka.assignment3;

//import java.lang.Comparable;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

     private String name;
     private  int age;

     public Employee(String name, int age){
         this.name = name;
         this.age = age;
     }

     public String getName(){
         return this.name;
     }
     public int getAge(){
         return this.age;
     }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }

    public static Comparator<Employee> compareByName = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Employee> compareByAge = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge()- o2.getAge();
        }
    };


}
