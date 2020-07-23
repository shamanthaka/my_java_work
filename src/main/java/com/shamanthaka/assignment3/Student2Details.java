package com.shamanthaka.assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class Student2Details {
    public static void main(String[] args) {
        ArrayList<Student2> students = new ArrayList<>();

        Student2 student2 = new Student2(23,"vinny");
        students.add(student2);

        student2 = new Student2(21,"anitha");
        students.add(student2);

        student2 = new Student2(20,"srijan");
        students.add(student2);

        student2 = new Student2(24,"venkat");
        students.add(student2);

        student2 = new Student2(65,"james");
        students.add(student2);

        for (Student2 s :students){
            System.out.println(s);
        }

//        Collections.sort(students);
//        System.out.println("Sorting: ");
//        for (Student2 s :students){
//            System.out.println(s);
//        }
        System.out.println("Sort by name");
        Collections.sort(students, Student2.sortByName);
        for (Student2 s :students){
            System.out.println(s);
        }

        System.out.println("Sort by rollno");
        Collections.sort(students, Student2.sortByRollNo);
        for (Student2 s :students){
            System.out.println(s);
        }

    }
}
