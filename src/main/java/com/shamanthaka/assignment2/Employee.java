package com.shamanthaka.assignment2;

public class Employee extends Object {
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

}
