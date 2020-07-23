package com.shamanthaka.assignment3;

import java.util.Comparator;

public class Student2 implements Comparable<Student2> {
    private int rollNo;
    private String name;

    public Student2(int rollNo,String name){
        this.rollNo = rollNo;
        this.name = name;
    }
    public int getRollNo(){
        return this.rollNo;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return this.name + ", " +this.rollNo;
    }

    @Override
    public int compareTo(Student2 that){
        return this.name.compareTo(that.name);
    }

    public static Comparator<Student2> sortByRollNo = new Comparator<Student2>() {
        @Override
        public int compare(Student2 o1, Student2 o2) {
            return o1.rollNo - o2.rollNo;
        }
    };

    public static Comparator<Student2> sortByName = new Comparator<Student2>() {
        @Override
        public int compare(Student2 o1, Student2 o2) {
            return o1.name.compareTo(o2.name);
        }
    };
}
