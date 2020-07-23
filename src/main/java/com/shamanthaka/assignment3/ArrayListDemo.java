package com.shamanthaka.assignment3;

import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args) {
        Student student = new Student();
        student.setNames();
        student.printNames();
        while(true) {
            System.out.println("Enter a name to search to come out from while enter no: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            if(name.equals("no")){
                break;
            }
            student.searchName(name);
        }

        System.out.println("Search name by index, enter a index");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        student.searchName(index);

        System.out.println("Enter a name to remove ");
        String name = scanner.next();
        student.removeName(name);
    }
}
