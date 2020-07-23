package com.shamanthaka.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private ArrayList<String> names = new ArrayList<>();

    public void setNames(){
        Scanner sc = new Scanner(System.in);
        String name = "";
        while(true){
            System.out.println("Enter names to exit from while loop enter no");
            name = sc.next();
            if(name.equals("no")){
                break;
            }
            names.add(name);
        }
    }

    public void printNames(){
        for(String name: names){
            System.out.println(name);
        }
    }

    public void searchName(String name){
        for(String s: names) {
            if(s.equals(name)){
                System.out.println(name + " found");
                break;
            }
        }
    }

    public void searchName(int index){
        if(index <= names.size()){
            String name = names.get(index);
            System.out.println(name);
        }
    }

    public void removeName(String name){
        boolean isRemoved = names.remove(name);
        if(isRemoved){
            System.out.println(name + " Removed");
        }else{
            System.out.println(name + " not found");
        }
        this.printNames();
    }
}
